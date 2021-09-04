package com.android.project.welsen_android_exam

import android.app.Application
import com.android.project.welsen_android_exam.di.module.*
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivityApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        startKoin {
            androidContext(this@MainActivityApplication)
            modules(listOf(networkModule, apiServiceModule, dataSourceModule, repositoryModule, viewModelModule, realmModelModule))
        }
    }
}