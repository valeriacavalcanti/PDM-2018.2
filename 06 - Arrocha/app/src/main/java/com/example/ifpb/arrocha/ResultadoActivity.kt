package com.example.ifpb.arrocha

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView
    private lateinit var tvTentativas: TextView
    private lateinit var jogo: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.tvResultado = findViewById(R.id.tvResultadoMensagem)

        this.jogo = intent.getSerializableExtra("JOGO") as Arrocha

        if (this.jogo.getStatus() == Status.GANHOU){
            this.tvResultado.text = "GANHOU"
            this.tvResultado.setBackgroundColor(Color.GREEN)
        }else if (this.jogo.getStatus() == Status.PERDEU_INTERVALO){
            this.tvResultado.text = "PERDEU!!"
            this.tvResultado.setBackgroundColor(Color.RED)
        }else{
            this.tvResultado.text = "ARROCHOU"
            this.tvResultado.setBackgroundColor(Color.YELLOW)
        }

        this.tvTentativas = findViewById(R.id.tvResultadoTentativas)
        this.tvTentativas.text = "Tentativas: ${this.jogo.getContador()}"
    }
}
