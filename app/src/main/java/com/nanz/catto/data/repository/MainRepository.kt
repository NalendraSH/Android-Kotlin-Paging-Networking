package com.nanz.catto.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.aci.viuit.utils.Resource
import com.nanz.catto.data.extension.isSuccessAndNotNull
import com.nanz.catto.data.network.RetrofitInstance
import com.nanz.catto.data.paging.CatListPagingSource
import com.nanz.catto.data.response.CatResponse
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val retrofitInstance: RetrofitInstance) {

    fun getCatList(page: Int, limit: Int): MutableLiveData<Resource<List<CatResponse>>> {
        val dataResponse = MutableLiveData<Resource<List<CatResponse>>>()

        dataResponse.postValue(Resource.loading(null))
        retrofitInstance.buildRetrofit()
            .getCatList(page = page, limit = limit)
            .enqueue(object : Callback<List<CatResponse>> {

                override fun onResponse(
                    call: Call<List<CatResponse>>,
                    response: Response<List<CatResponse>>
                ) {
                    if (response.isSuccessAndNotNull()) {
                        Log.d("TAG", "onResponse: success")
                        response.body()?.let {
                            dataResponse.postValue(
                                Resource.success(
                                    it,
                                    response.code(),
                                    (call.request() as Request)
                                )
                            )
                        }
                    } else {
                        Log.d("TAG", "onResponse: fail")
                        dataResponse.postValue(
                            Resource.error(
                                response.message(),
                                response.code(),
                                null,
                                (call.request() as Request)
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<List<CatResponse>>, t: Throwable) {
                    Log.d("TAG", "onResponse: fail 2 t: $t")
                }

            })

        return dataResponse
    }

    fun getCatListPaging(): LiveData<PagingData<CatResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = 7
            ),
            pagingSourceFactory = {
                CatListPagingSource(retrofitInstance.buildRetrofit())
            }
        ).liveData
    }

}