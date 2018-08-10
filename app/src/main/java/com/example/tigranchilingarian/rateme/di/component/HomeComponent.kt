package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.di.module.HomeModule
import com.example.tigranchilingarian.rateme.ui.home.HomeActivity
import com.example.tigranchilingarian.rateme.ui.home.HomePresenter
import dagger.Subcomponent

@Subcomponent(modules = [(HomeModule::class)])
interface HomeComponent {

    fun plus(activity: HomeActivity)

    fun inject(presenter: HomePresenter)
}