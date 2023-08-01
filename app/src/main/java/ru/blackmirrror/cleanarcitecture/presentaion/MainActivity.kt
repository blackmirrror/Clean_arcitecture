package ru.blackmirrror.cleanarcitecture.presentaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.blackmirrror.cleanarcitecture.R
import ru.blackmirrror.cleanarcitecture.data.repository.UserRepositoryImpl
import ru.blackmirrror.cleanarcitecture.data.storage.SharedPrefUserStorage
import ru.blackmirrror.cleanarcitecture.domain.models.SaveUsernameParam
import ru.blackmirrror.cleanarcitecture.domain.usecases.GetUserNameUseCase
import ru.blackmirrror.cleanarcitecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("VM", "onCreate: ac created")

        val dataTextView = findViewById<TextView>(R.id.tv_data)
        val dataEditText = findViewById<EditText>(R.id.et_data)
        val saveButton = findViewById<Button>(R.id.btn_put)
        val getButton = findViewById<Button>(R.id.btn_get)

        viewModel.result.observe(this) {
            dataTextView.text = it
        }

        saveButton.setOnClickListener {
            val text = dataEditText.text.toString()
            viewModel.save(text)
        }

        getButton.setOnClickListener {
            viewModel.get()
        }
    }
}