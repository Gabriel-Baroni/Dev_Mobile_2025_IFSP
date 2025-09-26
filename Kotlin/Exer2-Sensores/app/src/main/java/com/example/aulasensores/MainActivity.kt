package com.example.aulasensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout)
        val sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

        val sensores = sensorManager.getSensorList(Sensor.TYPE_ALL)
        for (s in sensores) {
            Log.d("SENSORES", "${s.name} - tipo=${s.type}")
        }
/* Três sensores são: Sensor de luminosidade, serve para regular o nível de luminosidade da tela; Sensor de temperatura, para averiguar a temperatura do aparelho; Sensor Giroscópio, para medir a velocidade de rotação de um sensor*/

    }
}