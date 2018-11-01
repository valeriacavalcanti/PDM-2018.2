package com.example.ifpb.eventos

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TelaDesbloqueadaReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Tela desbloqueou", Toast.LENGTH_SHORT).show()
    }
}
