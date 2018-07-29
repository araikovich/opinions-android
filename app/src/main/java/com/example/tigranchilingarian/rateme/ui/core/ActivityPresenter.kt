package com.example.tigranchilingarian.rateme.ui.core

import android.os.Bundle
import com.example.tigranchilingarian.rateme.domain.util.IoToMainComposer
import rx.Observable
import rx.subjects.PublishSubject

abstract class ActivityPresenter<S : BaseScreen>(protected val screen: S) {

    private val detachStopper = PublishSubject.create<Void>()

    open fun onCreate(bundle: Bundle?) {}

    open fun onStart() {}

    open fun onResume() {}

    open fun onPause() {}

    open fun onStop() {
        detachStopper.onNext(null)
    }

    open fun onDestroy() {}

    open fun onBackPressed(): Boolean = true

    protected fun <T> bindView(): Observable.Transformer<T, T> {
        return Observable.Transformer { input -> input.takeUntil(detachStopper) }
    }

    protected fun <T> bindViewIoToMainComposer(): Observable.Transformer<T, T> {
        return Observable.Transformer { input -> input.compose(IoToMainComposer()).compose(bindView()) }
    }
}