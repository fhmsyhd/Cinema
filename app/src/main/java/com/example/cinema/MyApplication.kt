package com.example.cinema

import android.app.Application
import com.example.cinema.data.di.databaseModule
import com.example.cinema.data.di.networkModule
import com.example.cinema.data.di.repositoryModule
import com.example.cinema.di.useCaseModule
import com.example.cinema.di.viewModelModule
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