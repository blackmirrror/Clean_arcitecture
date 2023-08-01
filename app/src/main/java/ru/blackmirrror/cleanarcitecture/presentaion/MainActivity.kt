package ru.blackmirrror.cleanarcitecture.presentaion

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.blackmirrror.cleanarcitecture.R
import ru.blackmirrror.cleanarcitecture.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.d("VM", "onCreate: ac created")

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

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