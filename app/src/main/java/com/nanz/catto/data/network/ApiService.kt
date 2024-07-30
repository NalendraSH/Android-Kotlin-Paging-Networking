package com.nanz.catto.data.network

import com.nanz.catto.BuildConfig
import com.nanz.catto.data.response.CatResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("images/search")
    fun getCatList(
        @Header("x-api-key") token: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("has_breeds") hasBreeds: Int = 1,
    ): Call<List<CatResponse>>

}