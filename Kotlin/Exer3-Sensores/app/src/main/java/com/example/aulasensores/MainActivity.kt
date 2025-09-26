package com.example.aulasensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity(), SensorEventListener{
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout)
        val sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER)

        }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        TODO("Not yet implemented")
    }
/* Resposta: O onCreate é um metodo que inicializa o sensorManager, assim voce consegue configurar o sensor antes de iniciar a aplicação*/
}
