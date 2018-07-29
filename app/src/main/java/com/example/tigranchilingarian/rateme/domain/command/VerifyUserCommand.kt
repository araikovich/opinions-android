package com.example.tigranchilingarian.rateme.domain.command

import com.example.tigranchilingarian.rateme.data.storage.PreferencesStorage
import com.example.tigranchilingarian.rateme.di.component.CommandComponent
import com.example.tigranchilingarian.rateme.di.component.InjectableCommand
import io.techery.janet.Command
import io.techery.janet.command.annotations.CommandAction
import javax.inject.Inject

@CommandAction
class VerifyUserCommand(private val userId: Int) : Command<Void>(), InjectableCommand {

    @Inject
    lateinit var prefs: PreferencesStorage

    override fun inject(injector: CommandComponent) {
        injector.inject(this)
    }

    override fun run(callback: CommandCallback<Void>?) {
        callback?.onSuccess(null)
    }
}