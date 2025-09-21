package com.example.exerccio1intent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class Activity2 : ComponentActivity() {

    private lateinit var txtSaudar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout2)

        txtSaudar = findViewById(R.id.textView3)

        // 1. Recebe o nome enviado da MainActivity usando getStringExtra
        val name = intent.getStringExtra("USER_NAME")

        // 2. Monta a mensagem de saudação e a exibe no TextView
        txtSaudar.text = "Bem-vindo(a), $name!"
    }
}