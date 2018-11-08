package com.example.ifpb.carregador

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var aviaoReceiver: ModoAviaoReceiver
    private lateinit var carregadorReceiver: CarregadorReceiver

    private lateinit var ifAviao: IntentFilter
    private lateinit var ifCarredor: IntentFilter

    private lateinit var lvStatus: ListView

    private lateinit var dao: StatusDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = StatusDAO()

        this.lvStatus = findViewById(R.id.lvStatus)
        this.lvStatus.adapter = ArrayAdapter<Status>(this,
                                                      android.R.layout.simple_list_item_1,
                                                      this.dao.read())

        this.aviaoReceiver = ModoAviaoReceiver()
        this.carregadorReceiver = CarregadorReceiver()

        this.ifAviao = IntentFilter()
        this.ifAviao.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        this.ifCarredor = IntentFilter()
        this.ifCarredor.addAction(Intent.ACTION_POWER_CONNECTED)
        this.ifCarredor.addAction(Intent.ACTION_POWER_DISCONNECTED)

    }

    override fun onResume() {
        super.onResume()
        // receiver estevesse executando
        registerReceiver(this.aviaoReceiver, this.ifAviao)
        registerReceiver(this.carregadorReceiver, this.ifCarredor)
    }

    override fun onPause() {
        super.onPause()
        //receiver pare! por favor !
        unregisterReceiver(this.aviaoReceiver)
        unregisterReceiver(this.carregadorReceiver)
    }

    private fun atualizaLista(){
        (this.lvStatus.adapter as ArrayAdapter<Status>).notifyDataSetChanged()
    }

    inner class CarregadorReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_POWER_CONNECTED)
                dao.add(Status("Conectou"))
            else
                dao.add(Status("Desconectou"))

            atualizaLista()
        }
    }
}
