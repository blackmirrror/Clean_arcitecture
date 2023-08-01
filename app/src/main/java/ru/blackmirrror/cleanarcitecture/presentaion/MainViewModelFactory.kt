package ru.blackmirrror.cleanarcitecture.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.blackmirrror.cleanarcitecture.domain.usecases.GetUserNameUseCase
import ru.blackmirrror.cleanarcitecture.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}