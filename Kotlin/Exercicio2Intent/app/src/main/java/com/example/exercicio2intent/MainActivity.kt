package com.example.exercicio2intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
import androidx.core.net.toUri
import com.example.exercicio2intent.ui.theme.Exercicio2IntentTheme

class MainActivity : ComponentActivity() {

    private lateinit var btnSite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        btnSite = findViewById(R.id.button)

        btnSite.setOnClickListener {
            val uri = "https://jcr.ifsp.edu.br".toUri()
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nenhum navegador encontrado para abrir o site", Toast.LENGTH_LONG).show()
            }
        }

    }
}