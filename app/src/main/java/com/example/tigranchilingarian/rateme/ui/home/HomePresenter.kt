package com.example.tigranchilingarian.rateme.ui.home

import com.example.tigranchilingarian.rateme.di.component.HomeComponent
import com.example.tigranchilingarian.rateme.ui.core.ActivityPresenter
import com.example.tigranchilingarian.rateme.ui.core.BaseScreen

class HomePresenter(source: Screen, component: HomeComponent) : ActivityPresenter<HomePresenter.Screen>(source) {

    init {
        component.inject(this)
    }

    interface Screen : BaseScreen
}