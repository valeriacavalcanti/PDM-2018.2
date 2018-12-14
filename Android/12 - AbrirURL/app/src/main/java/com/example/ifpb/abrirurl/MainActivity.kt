package com.example.ifpb.abrirurl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etURL: EditText
    private lateinit var btAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etURL = findViewById(R.id.etURL)

        this.btAbrir = findViewById(R.id.btAbrir)

        this.btAbrir.setOnClickListener({
            val url = this.etURL.text.toString()
            val intent = Intent("EXECUTAR_MEU_BROWSER")
            intent.putExtra("URL", url)

            startActivity(intent)
        })
    }
}
