package com.example.tigranchilingarian.rateme.ui.splash_screen

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.data.storage.PreferencesStorage
import com.example.tigranchilingarian.rateme.databinding.ActivitySplashScreenBinding
import com.example.tigranchilingarian.rateme.di.module.SplashScreenModule
import com.example.tigranchilingarian.rateme.ui.core.BaseActivityWithPresenter
import com.example.tigranchilingarian.rateme.ui.core.Layout
import com.example.tigranchilingarian.rateme.ui.core.WithBinding
import com.example.tigranchilingarian.rateme.ui.home.HomeActivity
import com.example.tigranchilingarian.rateme.ui.welcome.WelcomeActivity
import javax.inject.Inject


@Layout(id = R.layout.activity_splash_screen)
@WithBinding
class SplashScreenActivity : BaseActivityWithPresenter<SplashScreenPresenter.Screen, SplashScreenPresenter>(), SplashScreenPresenter.Screen {

    @Inject
    lateinit var preferencesStorage: PreferencesStorage

    private val component by lazy { app.component.plus(SplashScreenModule(this)) }

    private lateinit var binding: ActivitySplashScreenBinding


    override fun createPresenter(): SplashScreenPresenter = SplashScreenPresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startOpinions()
    }

    override fun startOpinions() {
        if (preferencesStorage.isVerifyUser()) {
            HomeActivity.start(this)
        } else {
            WelcomeActivity.start(this)
        }
    }

    override fun setupContentWithBinding(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}
