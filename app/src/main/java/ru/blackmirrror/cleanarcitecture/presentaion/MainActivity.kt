package ru.blackmirrror.cleanarcitecture.presentaion

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.blackmirrror.cleanarcitecture.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

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