package ru.blackmirrror.cleanarcitecture.domain.usecases

import ru.blackmirrror.cleanarcitecture.domain.models.Username
import ru.blackmirrror.cleanarcitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): Username {
        return userRepository.getName()
    }
}