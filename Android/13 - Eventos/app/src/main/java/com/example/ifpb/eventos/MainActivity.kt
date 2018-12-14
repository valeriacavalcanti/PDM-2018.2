package com.example.ifpb.eventos

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var modoAviao: ModoAviaoReceiver
    private lateinit var ifModoAviao: IntentFilter
    private lateinit var tvEvento: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.modoAviao = ModoAviaoReceiver()
        this.ifModoAviao = IntentFilter()
        this.ifModoAviao.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        this.tvEvento = findViewById(R.id.tvEvento)
    }

    override fun onResume() {
        super.onResume()
        // registrar o receiver
        registerReceiver(this.modoAviao, this.ifModoAviao)
    }

    override fun onPause() {
        super.onPause()
        // remover o receiver
        unregisterReceiver(this.modoAviao)
    }
}
