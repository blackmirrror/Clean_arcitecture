package ru.blackmirrror.cleanarcitecture.app

import android.app.Application
import ru.blackmirrror.cleanarcitecture.di.AppComponent
import ru.blackmirrror.cleanarcitecture.di.AppModule
import ru.blackmirrror.cleanarcitecture.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}