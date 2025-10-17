package com.example.canvas_view

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
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
        val res: Resources = getResources()
        val desenhoView = DesenhoView(this)
        desenhoView.setResource(res)
        setContentView(desenhoView)




    }
}

class DesenhoView(context: Context) : View(context) {


    lateinit var res: Resources;
    public fun setResource(resources: Resources){
        res = resources

    }


    private val paint = Paint().apply {
        color = Color.BLUE
    }

    override fun onDraw ( canvas : Canvas) {
        super.onDraw ( canvas )
        canvas.drawCircle (200f , 200f , 100f , paint )
        paint.color = Color.BLACK
        paint.textSize = 48f
        canvas.drawText("Olá Canvas", 50f , 400f , paint)
        val bitmap = BitmapFactory.decodeResource(res, R.drawable.images)
        canvas.drawBitmap ( bitmap , 0f , 800f , null )
        val x = ( width - bitmap . width ) / 2f
        val y = ( height - bitmap . height ) / 2f
        canvas.drawBitmap ( bitmap , x , y , null )

    }


}