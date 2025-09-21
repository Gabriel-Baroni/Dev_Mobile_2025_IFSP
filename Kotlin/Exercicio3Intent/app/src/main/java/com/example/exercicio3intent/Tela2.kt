package com.example.exercicio3intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class Tela2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout2)

        val edtNickname: EditText = findViewById(R.id.edtNickname)
        val btnConfirm: Button = findViewById(R.id.btnConfirmNickname)

        btnConfirm.setOnClickListener {
            val nickname = edtNickname.text.toString()

            if (nickname.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("NICKNAME_RESULT", nickname)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                edtNickname.error = "Campo obrigatório"
            }
        }
    }
}