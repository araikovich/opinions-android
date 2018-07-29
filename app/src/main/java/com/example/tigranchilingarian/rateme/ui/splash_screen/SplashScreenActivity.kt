package com.example.tigranchilingarian.rateme.ui.splash_screen

import android.os.Bundle
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.data.storage.PreferencesStorage
import com.example.tigranchilingarian.rateme.di.module.SplashScreenModule
import com.example.tigranchilingarian.rateme.ui.core.BaseActivityWithPresenter
import javax.inject.Inject


class SplashScreenActivity : BaseActivityWithPresenter<SplashScreenPresenter.Screen, SplashScreenPresenter>(), SplashScreenPresenter.Screen {

    @Inject
    lateinit var preferencesStorage: PreferencesStorage

    private val component by lazy { app.component.plus(SplashScreenModule(this)) }


    override fun createPresenter(): SplashScreenPresenter = SplashScreenPresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun startOpinions() {

    }
}
