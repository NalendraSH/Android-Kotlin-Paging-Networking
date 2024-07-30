package com.nanz.catto

import android.app.Application
import com.nanz.catto.di.appModule
import com.nanz.catto.di.repositoryModule
import com.nanz.catto.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

}