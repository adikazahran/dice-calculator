package com.example.newproject1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.roundToInt

class halaman2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman2)

        // Handle window insets for edge-to-edge experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Access all the UI elements
        val angkaPertama = findViewById<EditText>(R.id.angkaPertama)
        val angkaKedua = findViewById<EditText>(R.id.angkaKedua)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val hasil = findViewById<TextView>(R.id.hasil)
        val tombolHitung = findViewById<Button>(R.id.tombolhitung)

        // Tombol untuk kembali ke halaman dadu (MainActivity)
        val tombolGotoDadu = findViewById<Button>(R.id.gotoDadu)
        tombolGotoDadu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Functionality for the "hitung" button
        tombolHitung.setOnClickListener {
            // Retrieve the input numbers (convert to Double)
            val firstNumber = angkaPertama.text.toString().toDoubleOrNull() ?: 0.0
            val secondNumber = angkaKedua.text.toString().toDoubleOrNull() ?: 0.0

            // Get the selected radio button id
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            var result = 0.0

            // Perform the corresponding operation based on selected RadioButton
            when (selectedRadioButtonId) {
                R.id.kali -> result = firstNumber * secondNumber
                R.id.tambah -> result = firstNumber + secondNumber
                R.id.kurang -> result = firstNumber - secondNumber
                R.id.bagi -> result = firstNumber / secondNumber
            }

            // Display the result
            hasil.text = result.roundToInt().toString()
        }
    }
}

//Change 1
//Change 2