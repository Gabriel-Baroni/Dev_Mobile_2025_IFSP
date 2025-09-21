package com.example.exercicio3intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercicio3intent.ui.theme.Exercicio3IntentTheme

class MainActivity : ComponentActivity() {
    private lateinit var txtNicknameLabel: TextView
    private lateinit var btnGetNickname: Button
    private lateinit var nicknameResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout1)

        txtNicknameLabel = findViewById(R.id.txtNicknameLabel)
        btnGetNickname = findViewById(R.id.btnGetNickname)

        nicknameResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val nickname = data?.getStringExtra("NICKNAME_RESULT")
                txtNicknameLabel.text = "Bem-vindo(a), $nickname!"
            }
        }


        btnGetNickname.setOnClickListener {
            val intent = Intent(this, Tela2::class.java)
            nicknameResultLauncher.launch(intent)
        }
    }
}