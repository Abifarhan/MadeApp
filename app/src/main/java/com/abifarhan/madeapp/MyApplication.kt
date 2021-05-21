package com.abifarhan.madeapp

import android.app.Application
import com.abifarhan.madeapp.core.di.databaseModule
import com.abifarhan.madeapp.core.di.networkModule
import com.abifarhan.madeapp.core.di.repositoryModule
import com.abifarhan.madeapp.di.useCaseModule
import com.abifarhan.madeapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}