package com.pushkovav.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class AntefactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antefaction)
    }

    fun isValidString(str: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    override fun onResume() {
        super.onResume()
        val buttonNext = findViewById<Button>(R.id.buttonNext)
        val editText = findViewById<EditText>(R.id.editText)
        var isValidate = false
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isValidString(s.toString())) {
                    isValidate = true
                    buttonNext.setBackgroundColor(getColor(R.color.Filling))
                } else {
                    buttonNext.setBackgroundColor(getColor(R.color.isNotFilling))
                    isValidate = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        buttonNext.setOnClickListener {
            if (isValidate){
                val i = Intent(this, ConfirmationEmailActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}