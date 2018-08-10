package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.di.module.LoginModule
import com.example.tigranchilingarian.rateme.ui.login.LoginActivity
import com.example.tigranchilingarian.rateme.ui.login.LoginPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun plus(activity: LoginActivity)

    fun inject(presenter: LoginPresenter)
}