package com.example.ifpb.depende

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        Log.i("APP_DEPENDE", "OnCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.w("APP_DEPENDE", "OnStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("APP_DEPENDE", "OnResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_DEPENDE", "OnPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_DEPENDE", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_DEPENDE", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_DEPENDE", "OnDestroy")
    }
}
