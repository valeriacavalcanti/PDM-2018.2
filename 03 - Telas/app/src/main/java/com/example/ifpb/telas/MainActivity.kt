package com.example.ifpb.telas

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btVai: Button
    private val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_TELAS", "Main - onCreate")

        this.btVai = findViewById(R.id.btMainVai)
        this.btVai.setOnClickListener({ click(it) })
    }

    private fun click(view : View){
        val intent = Intent(this, OutraActivity::class.java)
        intent.putExtra("RESULTADO", "GANHOU")
        //startActivity(intent)
        startActivityForResult(intent, OUTRA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == OUTRA){
                Log.i("APP_TELAS", data!!.getStringExtra("CHOCOLATE"))
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_TELAS", "Main - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_TELAS", "Main - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_TELAS", "Main - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_TELAS", "Main - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_TELAS", "Main - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_TELAS", "Main - onDestroy")
    }
}
