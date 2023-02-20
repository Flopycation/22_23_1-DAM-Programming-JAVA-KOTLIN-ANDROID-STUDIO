
package com.example.miwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asignar archivo de diseño XML a la actividad
        setContentView(R.layout.activity_main)

        // Configurar WebView
        val miWebView: WebView = findViewById(R.id.web_View)

        // Configurar cliente de Chrome para WebView
        miWebView.webChromeClient = object : WebChromeClient() {

        }

        // Configurar cliente de WebView
        miWebView.webViewClient = object : WebViewClient() {

        }

        // Habilitar la ejecución de código JavaScript en WebView
        val configuracion: WebSettings = miWebView
