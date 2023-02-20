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

        // Asigna el archivo de diseño XML a la actividad
        setContentView(R.layout.activity_main)

        // Crea una instancia de WebView con el identificador "web_view" definido en el archivo de diseño XML
        val webView: WebView = findViewById(R.id.web_view)

        // Configura el cliente de Chrome para WebView
        webView.webChromeClient = object : WebChromeClient() {
            // Aquí se puede agregar código personalizado para el cliente de Chrome, si es necesario
        }

        // Configura el cliente de WebView
        webView.webViewClient = object : WebViewClient() {
            // Aquí se puede agregar código personalizado para el cliente de WebView, si es necesario
        }

        // Habilita la ejecución de código JavaScript en WebView
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true

        // Carga una URL en WebView
        webView.loadUrl("https://www.example.com")
    }
}
