package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.di.module.SplashScreenModule
import com.example.tigranchilingarian.rateme.ui.splash_screen.SplashScreenActivity
import com.example.tigranchilingarian.rateme.ui.splash_screen.SplashScreenPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(SplashScreenModule::class))
interface SplashScreenComponent {

    fun plus(activity: SplashScreenActivity)

    fun inject(presenter: SplashScreenPresenter)
}