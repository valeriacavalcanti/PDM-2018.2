package com.example.ifpb.telas

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class OutraActivity : AppCompatActivity() {
    private lateinit var btVolta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        Log.i("APP_TELAS", "Outra - onCreate")

        Log.i("APP_TELAS", intent.getStringExtra("RESULTADO"))

        this.btVolta = findViewById(R.id.btOutraVolta)
        this.btVolta.setOnClickListener({ click(it) })
    }

    private fun click(view: View){
        val intent = Intent()
        intent.putExtra("CHOCOLATE", "Fofão")
        setResult(Activity.RESULT_OK, intent)
        Log.i("APP_TELAS", "Vou voltar!! Com Chocolate!!!!")
        finish()
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_TELAS", "Outra - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_TELAS", "Outra - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_TELAS", "Outra - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_TELAS", "Outra - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_TELAS", "Outra - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_TELAS", "Outra - onDestroy")
    }
}