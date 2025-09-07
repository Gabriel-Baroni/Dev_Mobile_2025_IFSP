package com.example.aula02formularopedido

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val btn: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)
        val checkQ: CheckBox = findViewById(R.id.checkBoxQ)
        val checkB: CheckBox = findViewById(R.id.checkBoxB)
        val checkO: CheckBox = findViewById(R.id.checkBoxO)
        val radioGroup: RadioGroup = findViewById(R.id.meuGroup)
        val swtDelivery: Switch = findViewById(R.id.switch1)
        val nome: EditText = findViewById(R.id.edtNome)

        btn.setOnClickListener {
            var preco = 0.0
            var tamanho = ""

            // Verifica o tamanho do lanche selecionado
            when (radioGroup.checkedRadioButtonId) {
                R.id.radioP -> {
                    tamanho = "Tamanho Pequeno"
                    preco += 16
                }
                R.id.radioM -> {
                    tamanho = "Tamanho Médio"
                    preco += 18
                }
                R.id.radioG -> {
                    tamanho = "Tamanho Grande"
                    preco += 20
                }
            }

            // Extras selecionados
            val extrasSelecionados = mutableListOf<String>()
            if (checkQ.isChecked) {
                preco += 2
                extrasSelecionados.add("Queijo")
            }
            if (checkB.isChecked) {
                preco += 6
                extrasSelecionados.add("Bacon")
            }
            if (checkO.isChecked) {
                preco += 5
                extrasSelecionados.add("Ovo")
            }

            // Bebida do spinner
            val bebida = spinner.selectedItem.toString()
            preco += when (bebida) {
                "Agua" -> 3
                "Refrigerante" -> 5
                else -> 6
            }

            // Delivery
            val entrega = if (swtDelivery.isChecked) "Com Delivery" else "Retirada no balcão"
            if (swtDelivery.isChecked) preco += 5

            // Nome do cliente
            val cliente = nome.text.toString()

            // Mostra resumo
            AlertDialog.Builder(this)
                .setTitle("Resumo do Pedido")
                .setMessage(
                    "Cliente: $cliente\n" +
                            "Tamanho: $tamanho\n" +
                            "Extras: ${if (extrasSelecionados.isEmpty()) "Nenhum" else extrasSelecionados.joinToString(", ")}\n" +
                            "Bebida: $bebida\n" +
                            "Entrega: $entrega\n" +
                            "Total: R$ $preco"
                )
                .setPositiveButton("OK", null)
                .show()
        }
    }
}
