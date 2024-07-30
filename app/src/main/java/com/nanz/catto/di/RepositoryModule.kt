package com.nanz.catto.di

import com.nanz.catto.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get()) }
}