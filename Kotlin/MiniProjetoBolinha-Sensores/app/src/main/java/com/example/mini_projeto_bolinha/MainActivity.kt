package com.example.mini_projeto_bolinha

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class MainActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private lateinit var desenhoView: DesenhoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER
        )
        desenhoView = DesenhoView(this)
        setContentView(desenhoView)
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
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val ax = event.values[0]
            val ay = event.values[1]
            desenhoView.updatePosition(-ax, ay)
        }

    }


}

class DesenhoView(context: Context) : View(context) {
    private val paint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
    }

    private var x = 0f
    private var y = 0f
    private val radius = 80f

    private var viewWidth = 0
    private var viewHeight = 0

    private val speed = 10f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h

        x = (w / 2).toFloat()
        y = (h / 2).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(x, y, radius, paint)
    }

    fun updatePosition(ax: Float, ay: Float) {
        // Atualiza a posição com base na inclinação
        x += ax * speed
        y += ay * speed

        // Limites da tela
        if (x - radius < 0) x = radius
        if (x + radius > viewWidth) x = viewWidth - radius
        if (y - radius < 0) y = radius
        if (y + radius > viewHeight) y = viewHeight - radius

        // Redesenhar
        invalidate()
    }
}
