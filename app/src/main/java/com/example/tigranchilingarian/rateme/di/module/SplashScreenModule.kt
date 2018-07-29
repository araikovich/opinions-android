package com.example.tigranchilingarian.rateme.di.module

import android.app.Activity
import com.example.tigranchilingarian.rateme.ui.splash_screen.SplashScreenActivity
import dagger.Module
import dagger.Provides

@Module
class SplashScreenModule(private val activity: SplashScreenActivity) {

    @Provides
    fun providesActivity(): Activity = activity
}