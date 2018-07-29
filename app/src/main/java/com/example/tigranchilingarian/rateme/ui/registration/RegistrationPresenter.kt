package com.example.tigranchilingarian.rateme.ui.registration

import com.example.tigranchilingarian.rateme.di.component.RegistrationComponent
import com.example.tigranchilingarian.rateme.domain.interactor.LoginInteractor
import com.example.tigranchilingarian.rateme.ui.core.ActivityPresenter
import com.example.tigranchilingarian.rateme.ui.core.BaseScreen
import javax.inject.Inject

class RegistrationPresenter(sourceScreen: RegistrationPresenter.Screen, registrationComponent: RegistrationComponent) : ActivityPresenter<RegistrationPresenter.Screen>(sourceScreen) {

    @Inject
    lateinit var loginInteractor: LoginInteractor

    init {
        registrationComponent.inject(this)
    }

    interface Screen : BaseScreen
}