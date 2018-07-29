package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.di.module.RegistrationModule
import com.example.tigranchilingarian.rateme.ui.registration.RegistrationActivity
import com.example.tigranchilingarian.rateme.ui.registration.RegistrationPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(RegistrationModule::class))
interface RegistrationComponent {

    fun plus(activity: RegistrationActivity)

    fun inject(presenter: RegistrationPresenter)
}