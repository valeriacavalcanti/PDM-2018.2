package com.example.ifpb.amiguinhos

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var amigo: Amigo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        if (intent.getSerializableExtra("AMIGO") != null){
            this.amigo = intent.getSerializableExtra("AMIGO") as Amigo
            this.etNome.text.append(this.amigo.nome)
        }else{
            this.amigo = Amigo()
        }

        this.btSalvar.setOnClickListener({ salvar(it) })

        this.btCancelar.setOnClickListener({
            this.finish()
        })
    }

    private fun salvar(view: View){
        val nome = this.etNome.text.toString()
        this.amigo.nome = nome

        val intent = Intent()
        intent.putExtra("AMIGO", this.amigo)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}
