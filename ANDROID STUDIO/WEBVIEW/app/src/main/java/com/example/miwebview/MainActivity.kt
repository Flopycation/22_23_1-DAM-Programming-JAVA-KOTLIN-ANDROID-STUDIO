package com.example.miwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebBackForwardList
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //WebView

        WebView.WebChromeClient = object : WebChromeClient(){

        }
        WebView.WebViewClient = object : WebViewClient(){

        }

        val settings: WebSettings = WebView.settings
        settings.javaScriptEnabled = true
    }
}