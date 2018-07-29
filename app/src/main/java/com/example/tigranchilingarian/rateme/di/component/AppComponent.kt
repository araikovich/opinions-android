package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.App
import com.example.tigranchilingarian.rateme.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class),
    (StorageModule::class),
    (NetworkModule::class),
    (InteractorModule::class)])
interface AppComponent {

    fun inject(app: App)

    fun plus(registrationModule: RegistrationModule): RegistrationComponent

    fun plus(splashScreenModule: SplashScreenModule): SplashScreenComponent
}