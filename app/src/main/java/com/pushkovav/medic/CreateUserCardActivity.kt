package com.pushkovav.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner




class CreateUserCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user_card)


    }

    override fun onResume() {
        super.onResume()

        val buttonSkip = findViewById<Button>(R.id.buttonSkip)

        buttonSkip.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val spinner = findViewById<Spinner>(R.id.spinnerGender)

        // Настраиваем адаптер
        val adapter= ArrayAdapter.createFromResource(
            this, R.array.Gender,
            R.layout.input_area
        )
        adapter.setDropDownViewResource(R.layout.spinner_background)

        // Вызываем адаптер
        spinner.adapter = adapter

        val textName = findViewById<EditText>(R.id.textName)
        val textMiddleName = findViewById<EditText>(R.id.textMiddleName)
        val textLastName = findViewById<EditText>(R.id.textLastName)
        val textDate = findViewById<EditText>(R.id.textDateOfBirth)
        val btnCreate = findViewById<Button>(R.id.createCard)


        textName.addTextChangedListener(object :TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                fillingEditText(textName,count,0, btnCreate)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        textMiddleName.addTextChangedListener(object :TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fillingEditText(textMiddleName,count,1, btnCreate)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        textLastName.addTextChangedListener(object :TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fillingEditText(textLastName,count, 2, btnCreate)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        textDate.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fillingEditText(textDate,count,3, btnCreate)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                notNull[4] = position != 0
                checkFilling(btnCreate)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        btnCreate.setOnClickListener {
            if (isAllFilling){
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }

    }

    val notNull = arrayListOf(
        false,
        false,
        false,
        false,
        false
    )

    private var isAllFilling = false

    private fun fillingEditText(currentEditText: EditText, count: Int, numberEditText: Int, btnCreate: Button){
        if(count > 0){
            currentEditText.setBackgroundResource(R.drawable.fiiling_text_edit)
            notNull[numberEditText] = true
            checkFilling(btnCreate)
        }
        else{
            currentEditText.setBackgroundResource(R.drawable.edit_text)
            notNull[numberEditText] = false
            checkFilling(btnCreate)
        }
    }

    private fun checkFilling(btnCreate: Button){
        for (i in notNull.indices){
            if (!notNull[i]){
                isAllFilling = false
                btnCreate.setBackgroundColor(getColor(R.color.isNotFilling))
                break
            }
            else{
                btnCreate.setBackgroundColor(getColor(R.color.Filling))
                isAllFilling = true
            }
        }
    }
}