package com.example.ifpb.ifpb

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etUrl: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var campus: Campus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.etUrl = findViewById(R.id.etFormUrl)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener({ onClick(it) })
        this.btCancelar.setOnClickListener({ onClick(it) })

        if (intent.getSerializableExtra("CAMPUS_EDIT") != null){
            this.campus = intent.getSerializableExtra("CAMPUS_EDIT") as Campus
            this.etNome.text.append(campus.nome)
            this.etUrl.text.append(campus.url)
        }else{
            this.campus = Campus("", "")
        }
    }

    private fun onClick(view: View){
        if (view.equals(this.btSalvar)){
            val nome = this.etNome.text.toString()
            val url = this.etUrl.text.toString()

            this.campus.nome = nome
            this.campus.url = url

            val intent = Intent()
            intent.putExtra("CAMPUS", campus)

            setResult(Activity.RESULT_OK, intent)
        }
        finish()
    }
}
