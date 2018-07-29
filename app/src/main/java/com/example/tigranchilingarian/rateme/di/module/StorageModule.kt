package com.example.tigranchilingarian.rateme.di.module

import android.content.Context
import com.example.tigranchilingarian.rateme.data.storage.PreferencesStorage
import com.example.tigranchilingarian.rateme.data.storage.impl.PreferencesStorageImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(AppModule::class), (NetworkModule::class)])
class StorageModule {

    @Singleton
    @Provides
    fun ProvidePreferencesStorage(context: Context, gson: Gson): PreferencesStorage = PreferencesStorageImpl(context, gson)
}