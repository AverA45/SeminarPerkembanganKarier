package com.halu.seminarperkembangankarier

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val textResult = findViewById<TextView>(R.id.textResult)

        // Get data (String) from Explicit Intent (MainActivity)
        val dataNama = intent.getStringExtra("EXTRA_NAMA")
        val dataUsia = intent.getIntExtra("EXTRA_USIA", 0)

        textResult.text = getString(R.string.sapa, dataNama, dataUsia)

        btnKembali.setOnClickListener {
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}