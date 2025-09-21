package com.example.exerccio1intent

import android.content.Intent
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
import com.example.exerccio1intent.ui.theme.Exercício1IntentTheme
import android.widget.Button
import android.widget.EditText


class MainActivity : ComponentActivity() {
    private lateinit var edtName: EditText
    private lateinit var btnSaudar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout1)

        edtName = findViewById(R.id.editText)
        btnSaudar = findViewById(R.id.button)

        btnSaudar.setOnClickListener {
            val nome = edtName.text.toString()

            if (nome.isNotEmpty()){
                val intent = Intent(this, Activity2::class.java )
                intent.putExtra("USER_NAME", nome)
                startActivity(intent)

            } else {
                edtName.error = "Por favor, digite um nome"
            }
        }

    }
}