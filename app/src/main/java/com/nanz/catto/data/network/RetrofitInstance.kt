package com.nanz.catto.data.network

import com.google.gson.GsonBuilder
import com.nanz.catto.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance(private val okHttpClients: OkHttpClients) {

    fun buildRetrofit(): ApiService {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClients.provideClient())
            .build()
            .create(ApiService::class.java)
    }

}