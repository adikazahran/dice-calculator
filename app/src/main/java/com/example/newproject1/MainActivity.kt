package com.example.newproject1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textLabel = findViewById<TextView>(R.id.labelNama)
        textLabel.text = "Permainan Dadu"
        textLabel.setTextColor(getColor(R.color.purple))

        val textLabel1 = findViewById<TextView>(R.id.labelHobby)
        textLabel1.text = "Mobile"
        textLabel1.setTextColor(getColor(R.color.white))

        val tombolGanti = findViewById<Button>(R.id.tombolGanti)
        val tombolNext = findViewById<Button>(R.id.tombolNext) // untuk tombol Next
        val gambar = findViewById<ImageView>(R.id.gambar)

        // Mengganti gambar acak
        tombolGanti.setOnClickListener {
            currentNumber = randomdadu(gambar) // Menampilkan random dadu
        }

        tombolNext.setOnClickListener {
            nextGambar(gambar) // Memanggil fungsi untuk next gambar
        }

        // Tombol untuk berpindah ke halaman2 - New
        val tombolGoto2 = findViewById<Button>(R.id.gotoHalaman2)
        tombolGoto2.setOnClickListener {
            val intent = Intent(this, halaman2::class.java)
            startActivity(intent)
        }

        // Window insets handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Angka acak dari 1 sampai 6
    fun randomdadu(gambar: ImageView): Int {
        currentNumber = (1..6).random()
        gantigambar(currentNumber, gambar) // Memanggil gantigambar dengan angka acak
        return currentNumber // Mengembalikan angka yang dihasilkan
    }

    // Mengupdate gantigambar untuk menerima angka acak
    fun gantigambar(angka: Int, gambar: ImageView) {
        val resourceId = resources.getIdentifier("dadu$angka", "drawable", packageName)
        gambar.setImageDrawable(getDrawable(resourceId))
    }

    // Fungsi untuk mengganti gambar ke angka berikutnya
    fun nextGambar(gambar: ImageView) {
        currentNumber = if (currentNumber < 6) {
            currentNumber + 1 // Jika angka saat ini kurang dari 6, tambahkan 1
        } else {
            1 // Jika angka saat ini adalah 6, kembali ke 1
        }
        gantigambar(currentNumber, gambar) // Memanggil gantigambar dengan angka baru
    }
}
