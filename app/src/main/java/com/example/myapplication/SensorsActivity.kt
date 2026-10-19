package com.example.myapplication

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.IOException
import java.util.UUID

class SensorsActivity : AppCompatActivity() {

    // UUID estándar para módulos SPP (Serial Port Profile) como el HC-05
    private val MY_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    private var bluetoothSocket: BluetoothSocket? = null
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    // Vistas de la pantalla
    private lateinit var tvEstadoConexion: TextView
    private lateinit var tvValorSensor: TextView
    private lateinit var btnConectar: Button
    private lateinit var btnVolverMain: Button
    private lateinit var btnSiguienteControl: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors)

        // Vinculación de elementos del XML
        tvEstadoConexion = findViewById(R.id.tvEstadoConexion)
        tvValorSensor = findViewById(R.id.tvValorSensor)
        btnConectar = findViewById(R.id.btnConectar)
        btnVolverMain = findViewById(R.id.btnVolverMain)
        btnSiguienteControl = findViewById(R.id.btnSiguienteControl)

        // Botón para conectar buscando automáticamente el HC-05 emparejado
        btnConectar.setOnClickListener {
            conectarHC05Automatico()
        }

        // Navegación
        btnVolverMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSiguienteControl.setOnClickListener {
            val intent = Intent(this, ControlActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun conectarHC05Automatico() {
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "El dispositivo no soporta Bluetooth", Toast.LENGTH_SHORT).show()
            return
        }

        // Verificamos si el Bluetooth está encendido
        if (!bluetoothAdapter.isEnabled) {
            Toast.makeText(this, "Por favor, enciende el Bluetooth", Toast.LENGTH_SHORT).show()
            return
        }

        // Validación de permisos de conexión (Android 12+)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.BLUETOOTH_CONNECT), 1)
            Toast.makeText(this, "Concede los permisos de Bluetooth e intenta de nuevo", Toast.LENGTH_SHORT).show()
            return
        }

        // Obtenemos la lista de dispositivos vinculados al teléfono
        val dispositivosVinculados: Set<BluetoothDevice>? = bluetoothAdapter.bondedDevices
        var dispositivoHC05: BluetoothDevice? = null

        if (dispositivosVinculados != null && dispositivosVinculados.isNotEmpty()) {
            for (dispositivo in dispositivosVinculados) {
                // Buscamos el dispositivo que tenga por nombre "HC-05"
                if (dispositivo.name == "HC-05") {
                    dispositivoHC05 = dispositivo
                    break
                }
            }
        }

        if (dispositivoHC05 == null) {
            Toast.makeText(this, "No se encontró el 'HC-05'. ¡Empareja el módulo en los ajustes del teléfono!", Toast.LENGTH_LONG).show()
            tvEstadoConexion.text = "Estado: HC-05 no encontrado"
            return
        }

        // Intentamos establecer la conexión con el módulo encontrado
        try {
            bluetoothSocket = dispositivoHC05.createRfcommSocketToServiceRecord(MY_UUID)
            bluetoothAdapter.cancelDiscovery()

            bluetoothSocket?.connect()

            tvEstadoConexion.text = "Estado: Conectado a HC-05"
            Toast.makeText(this, "¡Conexión exitosa con el Arduino!", Toast.LENGTH_SHORT).show()

        } catch (e: IOException) {
            try {
                bluetoothSocket?.close()
            } catch (closeException: IOException) {
                // Error al cerrar socket secundario
            }
            tvEstadoConexion.text = "Estado: Error al conectar"
            Toast.makeText(this, "Error: Asegúrate de que el Arduino esté encendido.", Toast.LENGTH_LONG).show()
        }
    }
}