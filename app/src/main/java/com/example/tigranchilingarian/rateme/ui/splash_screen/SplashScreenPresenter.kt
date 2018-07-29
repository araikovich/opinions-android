package com.example.tigranchilingarian.rateme.ui.splash_screen

import com.example.tigranchilingarian.rateme.di.component.SplashScreenComponent
import com.example.tigranchilingarian.rateme.ui.core.ActivityPresenter
import com.example.tigranchilingarian.rateme.ui.core.BaseScreen

class SplashScreenPresenter(source: Screen, component: SplashScreenComponent) : ActivityPresenter<SplashScreenPresenter.Screen>(source) {

    init {
        component.inject(this)
    }

    interface Screen : BaseScreen {
        fun startOpinions()
    }
}