package com.example.ifpb.carregador

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ModoAviaoReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Ei, você mexeu! No Modo Avião!", Toast.LENGTH_SHORT).show()
    }
}
