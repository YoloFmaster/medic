package com.pushkovav.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageView

class ConfirmationEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_email)
    }


    override fun onResume() {
        super.onResume()
        val pastActivity = findViewById<ImageView>(R.id.backActivity)

        pastActivity.setOnClickListener{
            val i = Intent(this, AntefactionActivity::class.java)
            startActivity(i)
            finish()
        }
        var currentEditText = 0
        val number = mutableListOf<String>()
        val text1 = findViewById<EditText>(R.id.txt1)
        val text2 = findViewById<EditText>(R.id.txt2)
        val text3 = findViewById<EditText>(R.id.txt3)
        val text4 = findViewById<EditText>(R.id.txt4)

        val exampleCode = "1234"

        text1.isFocusableInTouchMode = true
        text1.requestFocus()
        text1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                number.add(s.toString())
                text1.isFocusableInTouchMode = false
                text2.isFocusableInTouchMode = true
                text2.requestFocus()
                currentEditText++
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        text2.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                number.clear()
                text1.isFocusableInTouchMode = true
                text1.text.clear()
                text1.requestFocus()
                text2.isFocusableInTouchMode = false
                currentEditText--
            }
            true
        }

        text2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                number.add(s.toString())
                text2.isFocusableInTouchMode = false
                text3.isFocusableInTouchMode = true
                text3.requestFocus()
                currentEditText++
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        text3.setOnKeyListener { _, keyCode, _ ->
            if (KeyEvent.KEYCODE_DEL == keyCode) {
                currentEditText--
                number.removeAt(currentEditText)
                text2.isFocusableInTouchMode = true
                text2.text.clear()
                text2.requestFocus()
                text3.isFocusableInTouchMode = false
            }
            true
        }

        text3.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                number.add(s.toString())
                text3.isFocusableInTouchMode = false
                text4.isFocusableInTouchMode = true
                text4.requestFocus()
                currentEditText++
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        text4.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                currentEditText--
                number.removeAt(currentEditText)
                text3.isFocusableInTouchMode = true
                text3.text.clear()
                text3.requestFocus()
                text4.isFocusableInTouchMode = false
            }
            true
        }

        text4.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                number.add(s.toString())
                currentEditText++
                if (checkResult(number, exampleCode)) nextActivity()
                else{
                    defaultSetting(text1,text2,text3,text4)
                    number.clear()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


    }

    private fun defaultSetting(text1: EditText, text2: EditText, text3: EditText, text4: EditText){
        text1.text.clear()
        text2.text.clear()
        text3.text.clear()
        text4.text.clear()
        text1.isFocusableInTouchMode = true
        text2.isFocusableInTouchMode = false
        text3.isFocusableInTouchMode = false
        text4.isFocusableInTouchMode = false
        text1.requestFocus()
    }

    private fun checkResult(text: List<String>, trueCode: String): Boolean {
        val number = text.joinToString("")
        return number == trueCode
    }

    private fun nextActivity(){
        val i = Intent(this, CreatePasswordActivity::class.java)
        startActivity(i)
        finish()
    }
}
