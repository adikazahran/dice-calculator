package com.example.newproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentNumber = 1
    private var currentDaduIndex = 0 // Indeks untuk tombol Next

    // Gambar dadu
    private val daftarGambar = listOf(
        R.drawable.dadu1,
        R.drawable.dadu2,
        R.drawable.dadu3,
        R.drawable.dadu4,
        R.drawable.dadu5,
        R.drawable.dadu6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menerima pesan Intent dari halaman sebelumnya
        val pesan = intent.getStringExtra("pesanPindahHalaman")
        if (!pesan.isNullOrEmpty()) {
            Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
        }

        // Mengakses semua elemen tampila
        val tombolGanti = findViewById<Button>(R.id.tombolGanti)
        val tombolNext = findViewById<Button>(R.id.tombolNext)
        val gambar = findViewById<ImageView>(R.id.gambar)
        val tombolGoto2 = findViewById<Button>(R.id.gotoHalaman2)

        // Mengganti gambar dadu secara acak
        tombolGanti.setOnClickListener {
            val hitung = (0..5).random()
            gambar.setImageResource(daftarGambar[hitung]) // Menggunakan setImageResource
        }

        // Tombol next untuk mengganti dadu secara urut
        tombolNext.setOnClickListener {
            currentDaduIndex = (currentDaduIndex + 1) % daftarGambar.size
            gambar.setImageResource(daftarGambar[currentDaduIndex])
        }

        // Tombol untuk kembali ke halaman kalkulator (halaman2)
        tombolGoto2.setOnClickListener {
            val intent = Intent(this, halaman2::class.java)
            intent.putExtra("pesanPindahHalaman", "dari halaman dadu")
            startActivity(intent)
        }

        // Mengatur ruang layar agar tampilan penuh
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
