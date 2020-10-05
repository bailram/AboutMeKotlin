package com.bailram.aboutmekotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bailram.aboutmekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // create binding object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // before data binding
//        setContentView(R.layout.activity_main)

        // after data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // before data binding
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }

        // after data binding
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        // before data binding
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        // after data binding
        binding.apply { // add .apply to make the code easy to read
            nicknameText.text = nicknameEdit.text
            invalidateAll() // in order to refresh the UI with the new data
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}