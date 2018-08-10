package com.example.tigranchilingarian.rateme.ui.home

import android.os.Bundle
import com.example.tigranchilingarian.rateme.R
import com.example.tigranchilingarian.rateme.di.module.HomeModule
import com.example.tigranchilingarian.rateme.ui.core.BaseActivity
import com.example.tigranchilingarian.rateme.ui.core.BaseActivityWithPresenter

class HomeActivity : BaseActivityWithPresenter<HomePresenter.Screen, HomePresenter>(), HomePresenter.Screen {

    companion object {
        fun start(context: BaseActivity) {
            context.startActivity(HomeActivity::class.java, true)
        }
    }

    private val component by lazy { app.component.plus(HomeModule(this)) }

    override fun createPresenter(): HomePresenter = HomePresenter(this, component)

    override fun injectComponent() {
        component.plus(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
