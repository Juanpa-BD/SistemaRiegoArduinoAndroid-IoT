package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculamos los botones de navegación de la Pantalla 2
        val btnBackToLogin = findViewById<Button>(R.id.btnBackToLogin)
        val btnNextToSensors = findViewById<Button>(R.id.btnNextToSensors)

        // Botón para volver al Login
        btnBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Botón para avanzar a la Pantalla 3 (Sensores y Conectividad)
        btnNextToSensors.setOnClickListener {
            val intent = Intent(this, SensorsActivity::class.java)
            startActivity(intent)
        }
    }
}