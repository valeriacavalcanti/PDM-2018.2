package com.example.ifpb.arrocha

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var tvLi: TextView
    private lateinit var tvLs: TextView
    private lateinit var etChute: EditText
    private lateinit var btJogar: Button
    private lateinit var jogo: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Arrocha()

        this.tvLi = findViewById(R.id.tvMainLi)
        this.tvLs = findViewById(R.id.tvMainLs)
        this.etChute = findViewById(R.id.etMainChute)
        this.btJogar = findViewById(R.id.btMainJogar)

        this.btJogar.setOnClickListener({ onclick(it) })

        this.atualizaView()
    }

    private fun atualizaView(){
        this.tvLi.text = this.jogo.getMenor().toString()
        this.tvLs.text = this.jogo.getMaior().toString()
    }

    fun onclick(view: View){
        val chute = this.etChute.text.toString().toInt()
        this.jogo.jogar(chute)

        if (this.jogo.getStatus() != Status.EM_CURSO){
            val intent = Intent(this, ResultadoActivity::class.java)

            if (this.jogo.getStatus() == Status.GANHOU){
                intent.putExtra("RESULTADO", "GANHOU")
            }else{
                intent.putExtra("RESULTADO", "PERDEU")
            }

            startActivity(intent)
        }

        this.atualizaView()
    }
}
