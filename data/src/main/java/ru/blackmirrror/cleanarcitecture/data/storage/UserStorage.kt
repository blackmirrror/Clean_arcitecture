package ru.blackmirrror.cleanarcitecture.data.storage

import ru.blackmirrror.cleanarcitecture.data.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}