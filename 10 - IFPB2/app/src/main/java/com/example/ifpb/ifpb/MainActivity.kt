package com.example.ifpb.ifpb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val ADD = 1
    private val EDIT = 2
    private lateinit var cadastro: Cadastro
    private lateinit var lvCampi: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.cadastro = Cadastro()

        fab.setOnClickListener { view ->
            val intent = Intent(this, FormActivity::class.java)
            startActivityForResult(intent, ADD)
        }

        this.lvCampi = findViewById(R.id.lvMainCampi)
        this.lvMainCampi.adapter = ArrayAdapter<Campus>(this,
                                                         android.R.layout.simple_list_item_1,
                                                         this.cadastro.get())

        this.lvCampi.setOnItemClickListener { parent, view, position, id ->
            val campus = this.cadastro.get(position)
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("CAMPUS_EDIT", campus)
            startActivityForResult(intent, EDIT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == ADD){
                val campus = data?.getSerializableExtra("CAMPUS") as Campus
                campus.id = this.cadastro.size() + 1
                this.cadastro.add(campus)
                this.atualizar()

                Log.i("APP_IFPB", "Adicionado com sucesso. ${this.cadastro.size()}")
            }else if (requestCode == EDIT){

            }
        }

    }

    private fun atualizar(){
        (this.lvCampi.adapter as ArrayAdapter<Campus>).notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is
        // present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
