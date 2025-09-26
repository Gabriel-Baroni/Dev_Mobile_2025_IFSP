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
    private lateinit var txtX: TextView
    private lateinit var txtY: TextView
    private lateinit var txtZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
         sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        enableEdgeToEdge()

         txtX = findViewById(R.id.txtX)
         txtY = findViewById(R.id.txtY)
         txtZ = findViewById(R.id.txtZ)

    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_GAME
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
    }
}
 /* Resposta: Quando você pausa o listener no onPause, você consegue interromper atividades que consomem a CPU, ajudando a economizar a bateria */
/*    */