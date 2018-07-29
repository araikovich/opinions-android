package com.example.tigranchilingarian.rateme.di.module

import com.example.tigranchilingarian.rateme.App
import com.example.tigranchilingarian.rateme.di.core.DaggerCommandActionWrapper
import dagger.Module
import dagger.Provides
import io.techery.janet.CommandActionService
import io.techery.janet.Janet
import javax.inject.Singleton

@Module(includes = [(AppModule::class)])
class JanetModule {

    @Provides
    @Singleton
    fun provideJanet(app: App): Janet {
        val setvice = CommandActionService()
        return Janet.Builder()
                .addService(setvice)
                .addService(DaggerCommandActionWrapper(app, setvice))
                .build()
    }
}