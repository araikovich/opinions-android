package com.example.tigranchilingarian.rateme.di.core

import com.example.tigranchilingarian.rateme.App
import com.example.tigranchilingarian.rateme.di.component.CommandComponent
import com.example.tigranchilingarian.rateme.di.component.DaggerCommandComponent
import com.example.tigranchilingarian.rateme.di.component.InjectableCommand
import io.techery.janet.ActionHolder
import io.techery.janet.ActionService
import io.techery.janet.ActionServiceWrapper
import io.techery.janet.JanetException

class DaggerCommandActionWrapper(app: App, service: ActionService) : ActionServiceWrapper(service) {

    val injector: CommandComponent by lazy {
        DaggerCommandComponent.builder()
                .appModule(app.appModule)
                .build()
    }

    override fun <A : Any?> onInterceptProgress(holder: ActionHolder<A>?, progress: Int) {}

    override fun <A : Any?> onInterceptStart(holder: ActionHolder<A>?) {
        if (holder != null && holder.action() is InjectableCommand) {
            (holder.action() as InjectableCommand).inject(injector)
        }
    }

    override fun <A : Any?> onInterceptSend(holder: ActionHolder<A>?): Boolean {
        return false
    }

    override fun <A : Any?> onInterceptCancel(holder: ActionHolder<A>?) {}

    override fun <A : Any?> onInterceptSuccess(holder: ActionHolder<A>?) {}

    override fun <A : Any?> onInterceptFail(holder: ActionHolder<A>?, e: JanetException?): Boolean {
        /*
        if (BuildConfig.ENABLE_LOGGER || ENABLE_LOGGING_FROM_SERVER) e?.printStackTrace()
        if (!BuildConfig.DEBUG) Crashlytics.logException(e)*/
        return false
    }
}
