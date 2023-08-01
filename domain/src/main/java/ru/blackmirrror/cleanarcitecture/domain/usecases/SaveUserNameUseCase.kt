package ru.blackmirrror.cleanarcitecture.domain.usecases

import ru.blackmirrror.cleanarcitecture.domain.models.SaveUsernameParam
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUsernameParam): Boolean {
        return userRepository.saveName(param = param)
    }
}