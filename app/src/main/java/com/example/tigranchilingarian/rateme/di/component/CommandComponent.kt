package com.example.tigranchilingarian.rateme.di.component

import com.example.tigranchilingarian.rateme.di.module.AppModule
import com.example.tigranchilingarian.rateme.di.module.StorageModule
import com.example.tigranchilingarian.rateme.domain.command.VerifyUserCommand
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (StorageModule::class)])
interface CommandComponent {

    fun inject(cmd: VerifyUserCommand)
}