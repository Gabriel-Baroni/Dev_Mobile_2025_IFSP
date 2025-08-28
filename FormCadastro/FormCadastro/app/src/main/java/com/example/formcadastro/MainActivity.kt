package com.example.formcadastro
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
        setContentView(R.layout.layout)
        val text: TextView = findViewById(R.id.oi)
        val edtNome: EditText = findViewById(R.id.nome)
        val edtEmail: EditText = findViewById(R.id.email)
        val edtPassword: EditText = findViewById(R.id.password)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "Formulário Enviado", Toast.
            LENGTH_SHORT).show()
            val text2: TextView = findViewById(R.id.textView2)
            text2.text = """
                Nome: ${edtNome.text}
                Email: ${edtEmail.text}
                Senha: ${edtPassword.text}
            """.trimIndent()
        }


    }
}