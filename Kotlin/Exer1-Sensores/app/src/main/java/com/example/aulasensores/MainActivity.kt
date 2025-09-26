package com.example.aulasensores

import android.content.Context
import android.os.Bundle
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
import com.example.aulasensores.ui.theme.AulaSensoresTheme
import android.hardware.SensorManager
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout)
        val sensorManager = getSystemService(
            Context.SENSOR_SERVICE
        ) as SensorManager

/* Resposta: Precisamos da classe SensorManager para acessar os sensores e utiliza-los
caso seja necessário, por exemplo, monitorar a movimentação do aparelho  */


    }
}