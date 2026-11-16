package com.halu.seminarperkembangankarier

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsia = findViewById<EditText>(R.id.etUsia)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnEvent = findViewById<Button>(R.id.btnEvent)

        // Explicit Intent with validation
        btnKirim.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val usia = etUsia.text.toString().trim()

            // Validation: Check if EditText is empty
            if (nama.isEmpty()) {
                etNama.error = "Nama harus diisi!"
                Toast.makeText(this, "Isi Nama Anda terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
            else if (usia.isEmpty()) {
                        etUsia.error = "Usia harus diisi!"
                        Toast.makeText(this, "Isi Usia Anda terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                val usia = usia.toInt()

                val intent = Intent(
                    this,
                    ResultActivity::class.java
                )
                intent.putExtra("EXTRA_NAMA", nama)
                intent.putExtra("EXTRA_USIA", usia)
                startActivity(intent)
            }
        }

        btnEvent.setOnClickListener {
            val query = "https://akprind.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, query.toUri())
            startActivity(intent)
        }
    }
}