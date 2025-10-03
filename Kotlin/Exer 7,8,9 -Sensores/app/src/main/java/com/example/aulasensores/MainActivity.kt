package com.example.aulasensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private var gyroscope: Sensor? = null
    private lateinit var txtX: TextView
    private lateinit var txtY: TextView
    private lateinit var txtZ: TextView

    private lateinit var txtGX: TextView

    private lateinit var txtGY: TextView

    private lateinit var txtGZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
         sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER
        )

        gyroscope =sensorManager.getDefaultSensor(
             Sensor.TYPE_GYROSCOPE
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        enableEdgeToEdge()

         txtX = findViewById(R.id.txtX)
         txtY = findViewById(R.id.txtY)
         txtZ = findViewById(R.id.txtZ)

        txtGX = findViewById(R.id.textGX)
        txtGY = findViewById(R.id.textGY)
        txtGZ = findViewById(R.id.textGZ)

    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
        gyroscope?.let {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_UI
            )
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {/* opcional */
    }

    override fun onSensorChanged(event: SensorEvent) {

        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            Log.d("Meus valores","x$x, y$y, z$z")

            txtX.text = "X: $x"
            txtY.text = "Y: $y"
            txtZ.text = "Z: $z"

        }

        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            val gx = event.values[0]
            val gy = event.values[1]
            val gz = event.values[2]

            Log.d("Meus valores 2","gx$gx, gy$gy, gz$gz")

            txtGX.text = "GX: $gx"
            txtGY.text = "GY: $gy"
            txtGZ.text = "GZ: $gz"

            if ( gz > 10){
                Log.d("AVISO","Virou rápido")
            }
        }
    }
}
/* Resposta 8: Percebi que os logs dos sensores ficaram muito mais lentos utilizando o delay NORMAL e muito rápido utilizando o delay GAME */
/* Resposta 9: O delay FASTEST, embora traga mais informações sobre os sensores, nem sempre é a melhor escolha, pois pode ser muito pesado pro sistema */
