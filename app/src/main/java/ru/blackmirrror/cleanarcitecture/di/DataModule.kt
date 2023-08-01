package ru.blackmirrror.cleanarcitecture.di

import org.koin.dsl.module
import ru.blackmirrror.cleanarcitecture.data.repository.UserRepositoryImpl
import ru.blackmirrror.cleanarcitecture.data.storage.SharedPrefUserStorage
import ru.blackmirrror.cleanarcitecture.data.storage.UserStorage
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}