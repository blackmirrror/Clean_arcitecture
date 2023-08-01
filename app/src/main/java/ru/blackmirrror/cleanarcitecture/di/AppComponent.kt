package ru.blackmirrror.cleanarcitecture.di

import dagger.Component
import ru.blackmirrror.cleanarcitecture.presentaion.MainActivity

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}