package com.example.tigranchilingarian.rateme.di.module

import com.example.tigranchilingarian.rateme.domain.interactor.LoginInteractor
import dagger.Module
import dagger.Provides
import io.techery.janet.Janet
import javax.inject.Singleton

@Module(includes = [(JanetModule::class)])
class InteractorModule {

    @Singleton
    @Provides
    fun provideLoginInteractor(janet: Janet): LoginInteractor = LoginInteractor(janet)
}