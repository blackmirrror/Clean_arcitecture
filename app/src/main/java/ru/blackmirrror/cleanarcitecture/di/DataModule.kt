package ru.blackmirrror.cleanarcitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.blackmirrror.cleanarcitecture.data.repository.UserRepositoryImpl
import ru.blackmirrror.cleanarcitecture.data.storage.SharedPrefUserStorage
import ru.blackmirrror.cleanarcitecture.data.storage.UserStorage
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}