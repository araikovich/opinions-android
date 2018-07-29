package com.example.tigranchilingarian.rateme

import android.app.Application
import com.example.tigranchilingarian.rateme.di.component.AppComponent
import com.example.tigranchilingarian.rateme.di.component.DaggerAppComponent
import com.example.tigranchilingarian.rateme.di.module.AppModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    val appModule by lazy { AppModule(this) }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(appModule)
                .build()
    }
}