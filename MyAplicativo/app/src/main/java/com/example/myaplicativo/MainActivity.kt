package com.example.myaplicativo

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState:
                          Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNome: EditText = findViewById(R.id.editText1)
        val text: TextView = findViewById(R.id.olaView)
        var estado: Int = 0
        val button: Button = findViewById(R.id.btnHello)
        button.setOnClickListener {
            Toast.makeText(this, "Mudei o texto", Toast.
            LENGTH_SHORT).show()
            val nome = edtNome.text.toString()
            if (estado == 0 ){
                text.text="Olá ${nome} "
                estado = 1
            }
            else{
                text.text="Olá Mundo"
                estado = 0

            }
        }
        val edtNum: EditText = findViewById(R.id.editText2)
        val text2: TextView = findViewById(R.id.textView2)
        val button2: Button = findViewById(R.id.button)
        button2.setOnClickListener {
            val numero = edtNum.text.toString().toInt()
            val dobro = numero*2
            text2.text= dobro.toString()
        }

    }
}