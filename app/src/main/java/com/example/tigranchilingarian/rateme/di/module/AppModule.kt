package com.example.tigranchilingarian.rateme.di.module

import android.content.Context
import com.example.tigranchilingarian.rateme.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}