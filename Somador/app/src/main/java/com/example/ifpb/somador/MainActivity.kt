package com.example.ifpb.somador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var botao: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numero1 = findViewById(R.id.etMainNumero1)
        this.numero2 = findViewById(R.id.etMainNumero2)
        this.botao = findViewById(R.id.btMainSomar)
        this.resultado = findViewById(R.id.tvMainResultado)

        this.botao.setOnClickListener({ somar(it) })
    }

    fun somar(view: View){
        val n1 = this.numero1.text.toString().toInt()
        val n2 = this.numero2.text.toString().toInt()
        val resultado_soma = n1 + n2
        this.resultado.text = "=${resultado_soma}"
    }
}
