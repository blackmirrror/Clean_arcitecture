package ru.blackmirrror.cleanarcitecture.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.blackmirrror.cleanarcitecture.di.appModule
import ru.blackmirrror.cleanarcitecture.di.dataModule
import ru.blackmirrror.cleanarcitecture.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}