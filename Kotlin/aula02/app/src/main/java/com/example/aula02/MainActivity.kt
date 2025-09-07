package com.example.aula02
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
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
import com.example.aula02.ui.theme.Aula02Theme
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Toast
import androidx.compose.material3.Checkbox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState:
                          Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val text: TextView = findViewById(R.id.textView)
        text.text = "Formulário Legal :)"
        val nome: EditText = findViewById(R.id.edtNome)
        val spinner: Spinner = findViewById(R.id.spinner)
        val check: CheckBox = findViewById(R.id.checkBox)
        val btn: Button = findViewById(R.id.button)

        ArrayAdapter.createFromResource(
            this,
            R.array.serie_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        btn.setOnClickListener {
            val estaMarcado: Boolean = check.isChecked
            val mensagem: String = """
                Nome: ${nome.text} Série: ${spinner.selectedItem} Aceite: ${check.isChecked}
            """.trimIndent()
            if (nome.text.isEmpty()){
                Toast.makeText(this, "Preencha o Nome", Toast.
                LENGTH_SHORT).show()
                nome.error="Digite o nome"
                return@setOnClickListener
            }
            else if (!estaMarcado ) {
                Toast.makeText(this, "Concorde com os nossos termos e venda sua alma", Toast.
                LENGTH_SHORT).show()
                check.error="Aceite os termos"
                return@setOnClickListener
            }

            else {
                Toast.makeText(this, "Mensagem: ${mensagem}", Toast.
                LENGTH_SHORT).show()
            }

        }

    }
}