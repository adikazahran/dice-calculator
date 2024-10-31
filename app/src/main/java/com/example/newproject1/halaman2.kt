package com.example.newproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class halaman2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman2)

        // Access all the UI elements
        val angkaPertama = findViewById<EditText>(R.id.angkaPertama)
        val angkaKedua = findViewById<EditText>(R.id.angkaKedua)
        val hasil = findViewById<TextView>(R.id.hasil)
        val tombolHitung = findViewById<Button>(R.id.tombolhitung)
        val pindahhalaman = findViewById<Button>(R.id.gotoDadu)
        val kali = findViewById<RadioButton>(R.id.kali)
        val tambah = findViewById<RadioButton>(R.id.tambah)
        val kurang = findViewById<RadioButton>(R.id.kurang)
        val bagi = findViewById<RadioButton>(R.id.bagi)

        // Handle window insets for edge-to-edge experience
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Functionality for the "hitung" button
        tombolHitung.setOnClickListener {
            if (kali.isChecked) {
                val result =
                    angkaPertama.text.toString().toInt() * angkaKedua.text.toString().toInt()
                hasil.text = result.toString()
            }

            if (tambah.isChecked) {
                val result =
                    angkaPertama.text.toString().toInt() + angkaKedua.text.toString().toInt()
                hasil.text = result.toString()
            }

            if (kurang.isChecked) {
                val result =
                    angkaPertama.text.toString().toInt() - angkaKedua.text.toString().toInt()
                hasil.text = result.toString()
            }

            if (bagi.isChecked) {
                val result =
                    angkaPertama.text.toString().toInt() / angkaKedua.text.toString().toInt()
                hasil.text = result.toString()
            }
        }

        // Tombol untuk kembali ke halaman dadu (MainActivity)
        pindahhalaman.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("pesanPindahHalaman", "dari halamaman kalkulator")
            startActivity(intent)
        })
        Toast.makeText(this,intent.getStringExtra("pesanPindahHalaman")
            .toString(),
            Toast.LENGTH_LONG).show()
    }
}