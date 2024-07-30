package com.nanz.catto.di

import com.nanz.catto.data.network.ApiInterceptor
import com.nanz.catto.data.network.OkHttpClients
import com.nanz.catto.data.network.RetrofitInstance
import org.koin.dsl.module

val appModule = module {
    single { ApiInterceptor() }
    single { OkHttpClients(get()) }
    single { RetrofitInstance(get()) }
}