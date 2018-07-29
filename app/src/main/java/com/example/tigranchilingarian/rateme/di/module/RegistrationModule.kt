package com.example.tigranchilingarian.rateme.di.module

import android.app.Activity
import com.example.tigranchilingarian.rateme.ui.registration.RegistrationActivity
import dagger.Module
import dagger.Provides

@Module
class RegistrationModule(private val activity: RegistrationActivity) {

    @Provides
    fun provideActivity(): Activity = activity
}