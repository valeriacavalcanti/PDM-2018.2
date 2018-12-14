package com.example.ifpb.ifpb

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var lvCampi: ListView
    private lateinit var ifpb: Ifpb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.ifpb = Ifpb()
        this.criaCampiIfpb()

        this.lvCampi = findViewById(R.id.lvMainCampi)
        this.lvCampi.adapter = ArrayAdapter(this,
                                             android.R.layout.simple_list_item_1,
                                             this.ifpb.lista)

        this.lvCampi.setOnItemClickListener({ parent, view, position, id ->
            Toast.makeText(this, this.ifpb.get(position).nome, Toast.LENGTH_SHORT).show()
        })

        this.lvCampi.setOnItemLongClickListener ({ parent, view, position, id ->
            //Toast.makeText(this, this.ifpb.get(position).url, Toast.LENGTH_SHORT).show()
            val uri = Uri.parse(this.ifpb.get(position).url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            true
        })
    }

    private fun criaCampiIfpb(){
        this.ifpb.add(Campus("João Pessoa", "http://www.ifpb.edu.br/joaopessoa"))
        this.ifpb.add(Campus("Campina Grande", "http://www.ifpb.edu.br/campinagrande"))
        this.ifpb.add(Campus("Cajazeiras", "http://www.ifpb.edu.br/cajazeiras"))
        this.ifpb.add(Campus("Sousa", "http://www.ifpb.edu.br/sousa"))
    }
}
