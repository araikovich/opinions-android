package com.example.tigranchilingarian.rateme.ui.login

import com.example.tigranchilingarian.rateme.di.component.LoginComponent
import com.example.tigranchilingarian.rateme.domain.interactor.LoginInteractor
import com.example.tigranchilingarian.rateme.ui.core.ActivityPresenter
import com.example.tigranchilingarian.rateme.ui.core.BaseScreen
import javax.inject.Inject

class LoginPresenter(source: LoginPresenter.Screen, component: LoginComponent) : ActivityPresenter<LoginPresenter.Screen>(source) {

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        component.inject(this)
    }

    interface Screen : BaseScreen {

        fun showProgressbar()

        fun hideProgressbar()
    }
}