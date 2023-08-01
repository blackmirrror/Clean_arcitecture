package ru.blackmirrror.cleanarcitecture.di

import dagger.Module
import dagger.Provides
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository
import ru.blackmirrror.cleanarcitecture.domain.usecases.GetUserNameUseCase
import ru.blackmirrror.cleanarcitecture.domain.usecases.SaveUserNameUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository)
    }

}