package com.example.tigranchilingarian.rateme.domain.util

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class IoToMainComposer<T> : Observable.Transformer<T, T> {

    override fun call(observable: rx.Observable<T>): rx.Observable<T> {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}