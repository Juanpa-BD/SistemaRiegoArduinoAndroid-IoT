package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        val btnEvento1 = findViewById<Button>(R.id.btnEvento1)
        val btnEvento2 = findViewById<Button>(R.id.btnEvento2)
        val btnVolverSensors = findViewById<Button>(R.id.btnVolverSensors)

        btnEvento1.setOnClickListener {
            Toast.makeText(this, "Comando '1' enviado: Riego Activado", Toast.LENGTH_SHORT).show()
        }

        btnEvento2.setOnClickListener {
            Toast.makeText(this, "Comando '0' enviado: Riego Desactivado", Toast.LENGTH_SHORT).show()
        }

        btnVolverSensors.setOnClickListener {
            val intent = Intent(this, SensorsActivity::class.java)
            startActivity(intent)
            finish()
        }
        val btnVolverLogin = findViewById<Button>(R.id.btnVolverLogin)

        btnVolverLogin.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}