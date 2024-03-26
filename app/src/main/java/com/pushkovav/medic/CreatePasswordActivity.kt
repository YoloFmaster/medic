package com.pushkovav.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CreatePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)
    }

    private var currentDot = 0
    private val dotId = arrayListOf(
        R.id.dot1,
        R.id.dot2,
        R.id.dot3,
        R.id.dot4,
    )

    private var isDelBtn = false

    override fun onResume() {
        super.onResume()

        val btn0 = findViewById<TextView>(R.id.num0)
        val btn1 = findViewById<TextView>(R.id.num1)
        val btn2 = findViewById<TextView>(R.id.num2)
        val btn3 = findViewById<TextView>(R.id.num3)
        val btn4 = findViewById<TextView>(R.id.num4)
        val btn5 = findViewById<TextView>(R.id.num5)
        val btn6 = findViewById<TextView>(R.id.num6)
        val btn7 = findViewById<TextView>(R.id.num7)
        val btn8 = findViewById<TextView>(R.id.num8)
        val btn9 = findViewById<TextView>(R.id.num9)
        val delBtn = findViewById<ConstraintLayout>(R.id.delBtn)
        val delBtn1 = findViewById<ImageView>(R.id.delBtnImg)
        val buttonSkip = findViewById<Button>(R.id.buttonSkip)


        btn0.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn0)
        }
        btn1.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn1)
        }
        btn2.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn2)
        }
        btn3.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn3)
        }
        btn4.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn4)
        }
        btn5.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn5)
        }
        btn6.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn6)
        }
        btn7.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn7)
        }
        btn8.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn8)
        }
        btn9.setOnClickListener {
            isDelBtn = false
            fillignDots()
            clickButton(btn9)
        }
        delBtn.setOnClickListener {
            isDelBtn = true
            fillignDots()
        }
        delBtn1.setOnClickListener {
            isDelBtn = true
            fillignDots()
        }
        buttonSkip.setOnClickListener {
            nextActivity()
        }

    }

    private fun clickButton(clickedButton:  TextView){
        clickedButton.setTextColor(getColor(R.color.white))
        clickedButton.setBackgroundResource(R.drawable.circle_number_blue)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                clickedButton.setTextColor(getColor(R.color.black))
                clickedButton.setBackgroundResource(R.drawable.circle_number)
            },
            100)
    }

    private fun fillignDots(){
        val dot = findViewById<ImageView>(dotId[currentDot])
        if(!isDelBtn){
            dot.setBackgroundResource(R.drawable.circle_filling)
            currentDot++
            if (currentDot == 4){
                nextActivity()
            }
        }
        else {
            dot.setBackgroundResource(R.drawable.circle)
            if (currentDot != 0) currentDot--
        }
    }


    private fun nextActivity(){
        val i = Intent(this, CreateUserCardActivity::class.java)
        startActivity(i)
        finish()
    }
}