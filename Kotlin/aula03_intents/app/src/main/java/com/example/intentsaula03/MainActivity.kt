package com.example.intentsaula03

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var launcherDetail: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)

        launcherDetail = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val nickname = result.data?.getStringExtra("nickname").orEmpty()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nickname", nickname)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btnGoDetail).setOnClickListener {
            val name = edtName.text.toString()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", name)
            launcherDetail.launch(intent)
        }

        findViewById<Button>(R.id.btnOpenSite).setOnClickListener {
            val uri = "https://www.ifsp.edu.br".toUri()
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }

        findViewById<Button>(R.id.btnShare).setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Estudando Intents!")
            }
            startActivity(Intent.createChooser(sendIntent, "Compartilhar com..."))
        }
    }
}
