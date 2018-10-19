package com.example.ifpb.ifpb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient

class BrowserActivity : AppCompatActivity() {
    private lateinit var wvUrl: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        val url = intent.getStringExtra("URL")

        Log.i("APP_IFPB", url)

        this.wvUrl = findViewById(R.id.wvBrowserURL)

        this.wvUrl.loadUrl(url)

        this.wvUrl.settings.javaScriptEnabled = true
        this.wvUrl.settings.setSupportZoom(false)

        this.wvUrl.webViewClient = WebViewClient()
    }
}
