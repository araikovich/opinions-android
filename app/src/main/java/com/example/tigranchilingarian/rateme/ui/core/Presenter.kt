package com.example.tigranchilingarian.rateme.ui.core

import android.content.Context
import android.content.res.Resources
import android.view.View
import com.example.tigranchilingarian.rateme.domain.util.IoToMainComposer
import rx.Observable
import rx.subjects.PublishSubject

abstract class Presenter<S : BaseScreen> {

    lateinit var screen: S
    lateinit var context: Context

    private val detachStopper = PublishSubject.create<Void>()

    protected lateinit var resources: Resources

    open fun onAttach(view: View) {
        resources = view.resources
    }

    open fun onDetach(view: View) {
        detachStopper.onNext(null)
    }

    protected fun <T> bindView(): Observable.Transformer<T, T> {
        return Observable.Transformer { input -> input.takeUntil(detachStopper) }
    }

    protected fun <T> bindViewIoToMainComposer(): Observable.Transformer<T, T> {
        return Observable.Transformer { input -> input.compose(IoToMainComposer()).compose(bindView()) }
    }
}