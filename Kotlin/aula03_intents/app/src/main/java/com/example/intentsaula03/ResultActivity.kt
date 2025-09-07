package com.example.intentsaula03
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView


class ResultActivity : AppCompatActivity () {
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        setContentView (R.layout.activity_result)

        val nickname = intent.getStringExtra ("nickname").orEmpty()
        findViewById<TextView>( R.id.txtResult).text =
            "Apelido recebido: $nickname"
    }
}