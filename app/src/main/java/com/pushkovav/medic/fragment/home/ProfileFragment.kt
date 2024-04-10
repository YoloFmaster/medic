package com.pushkovav.medic.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.pushkovav.medic.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner = view.findViewById<Spinner>(R.id.spinnerGender)

        // Настраиваем адаптер
        val adapter= this.context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.Gender,
                R.layout.input_area
            )
        }
        adapter?.setDropDownViewResource(R.layout.spinner_background)

        // Вызываем адаптер
        spinner.adapter = adapter

        val btnRedact = view.findViewById<Button>(R.id.redactCard)

        val textName = view.findViewById<EditText>(R.id.textName)
        val textMiddleName = view.findViewById<EditText>(R.id.textMiddleName)
        val textLastName = view.findViewById<EditText>(R.id.textLastName)
        val textDate = view.findViewById<EditText>(R.id.textDateOfBirth)
        val btnCreate = view.findViewById<Button>(R.id.createCard)
        var isRedact = true

        btnRedact.setOnClickListener {

            if (isRedact) {
                isRedact = false
                btnRedact.setText(R.string.save)
                textName.isFocusableInTouchMode = true
                textMiddleName.isFocusableInTouchMode = true
                textLastName.isFocusableInTouchMode = true
                textDate.isFocusableInTouchMode = true
            }
            else{
                isRedact = true
                btnRedact.setText(R.string.redact)
                textName.isFocusableInTouchMode = false
                textName.isFocusable = false
                textMiddleName.isFocusableInTouchMode = false
                textMiddleName.isFocusable = false
                textLastName.isFocusableInTouchMode = false
                textLastName.isFocusable = false
                textDate.isFocusableInTouchMode = false
                textDate.isFocusable = false
            }
        }
    }
}