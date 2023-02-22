package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    companion object {
        const val WEB_PAGE_URL = "https://www.google.es/"
    }

    private lateinit var visor: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        visor = findViewById(R.id.WebView)

        val visor = findViewById<WebView>(R.id.WebView)

        visor.webChromeClient = object : WebChromeClient(){

        }

        visor.webViewClient = object : WebViewClient(){

        }

        val settings:WebSettings = visor.settings
        settings.javaScriptEnabled = true

        visor.loadUrl("https://www.google.es")

    }
}
