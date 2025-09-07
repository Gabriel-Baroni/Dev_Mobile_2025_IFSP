package com.example.intentsaula03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.app.Activity

class DetailActivity : AppCompatActivity() {
    override fun onCreate (savedInstanceState : Bundle ?) {
        super.onCreate (savedInstanceState)
        setContentView (R.layout.activity_detail)
        val name = intent.getStringExtra ("name").orEmpty()
        findViewById <TextView> (R.id.txtHello).text = " Ol, $name !"

        findViewById <Button> (R.id.btnReturn).setOnClickListener {
            val nickname = findViewById <EditText> (R.id.edtNickname).text.toString()
            val data = Intent().apply {putExtra ("nickname", nickname) }
            setResult (Activity.RESULT_OK, data)
            finish()
        }
    }

}