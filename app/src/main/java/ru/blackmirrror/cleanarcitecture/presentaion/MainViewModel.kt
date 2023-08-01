package ru.blackmirrror.cleanarcitecture.presentaion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.blackmirrror.cleanarcitecture.domain.models.SaveUsernameParam
import ru.blackmirrror.cleanarcitecture.domain.usecases.GetUserNameUseCase
import ru.blackmirrror.cleanarcitecture.domain.usecases.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase,
private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result
    
    init {
        Log.d("VM", ": vm created")
    }

    fun save(text: String) {
        val saveUsernameParam = SaveUsernameParam(name = text)
        _result.value = saveUserNameUseCase.execute(param = saveUsernameParam).toString()
    }

    fun get() {
        val username = getUserNameUseCase.execute()
        _result.value = username.firstName + " " + username.lastName
    }
}