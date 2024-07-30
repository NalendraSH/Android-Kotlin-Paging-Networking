package com.nanz.catto.data.network

import com.nanz.catto.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class ApiInterceptor {

    fun provideInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

}