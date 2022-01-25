package com.example.chisomlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebviewActivity : AppCompatActivity() {

    lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webview = findViewById(R.id.webview)
        // Show progress bar

        webview.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // Hide progress bar
            }
        })

        val bundle = intent.extras
        val url = bundle?.getString("url")

        if (url != null) {
            webview.loadUrl(url)
        }

    }
}