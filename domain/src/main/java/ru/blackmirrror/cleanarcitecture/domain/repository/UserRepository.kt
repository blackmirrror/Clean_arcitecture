package ru.blackmirrror.cleanarcitecture.domain.repository

import ru.blackmirrror.cleanarcitecture.domain.models.SaveUsernameParam
import ru.blackmirrror.cleanarcitecture.domain.models.Username

interface UserRepository {
    fun saveName(param: SaveUsernameParam): Boolean
    fun getName(): Username
}