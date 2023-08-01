package ru.blackmirrror.cleanarcitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.blackmirrror.cleanarcitecture.data.repository.UserRepositoryImpl
import ru.blackmirrror.cleanarcitecture.data.storage.SharedPrefUserStorage
import ru.blackmirrror.cleanarcitecture.data.storage.UserStorage
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}