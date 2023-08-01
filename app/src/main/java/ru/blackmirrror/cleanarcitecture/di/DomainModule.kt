package ru.blackmirrror.cleanarcitecture.di

import org.koin.dsl.module
import ru.blackmirrror.cleanarcitecture.domain.usecases.GetUserNameUseCase
import ru.blackmirrror.cleanarcitecture.domain.usecases.SaveUserNameUseCase

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}