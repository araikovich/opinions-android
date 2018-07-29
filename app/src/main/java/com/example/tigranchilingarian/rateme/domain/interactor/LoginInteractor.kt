package com.example.tigranchilingarian.rateme.domain.interactor

import com.example.tigranchilingarian.rateme.domain.command.VerifyUserCommand
import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import rx.schedulers.Schedulers

class LoginInteractor(janet: Janet) {

    val verifyUserActionPipe: ActionPipe<VerifyUserCommand> = janet.createPipe(VerifyUserCommand::class.java, Schedulers.io())
}