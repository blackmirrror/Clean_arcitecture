package ru.blackmirrror.cleanarcitecture.data.repository

import ru.blackmirrror.cleanarcitecture.data.models.User
import ru.blackmirrror.cleanarcitecture.data.storage.UserStorage
import ru.blackmirrror.cleanarcitecture.domain.models.SaveUsernameParam
import ru.blackmirrror.cleanarcitecture.domain.models.Username
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(param: SaveUsernameParam): Boolean {
        val user = User(firstName = param.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getName(): Username {
        val user = userStorage.get()
        return Username(firstName = user.firstName, lastName = user.lastName)
    }
}