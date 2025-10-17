package com.example.canvas_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvas_view.ui.theme.Canvas_ViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(DesenhoView(this))

    }
}

class DesenhoView(context: Context) : View(context) {
    private val paint = Paint().apply {
        color = Color.BLUE

    }
    override fun onDraw ( canvas : Canvas) {
        super.onDraw ( canvas )
        canvas.drawCircle (200f , 200f , 100f , paint )

        paint.color = Color.BLACK
        paint.textSize = 48f
        canvas.drawText("Olá Canvas", 50f , 400f , paint)
    }


}