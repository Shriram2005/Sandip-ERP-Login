package com.shriram.sandipuniversity

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        // call web-view function
        val displayWeb = findViewById<WebView>(R.id.displayWeb)
        webViewSetup(displayWeb)
    }

    // web-view function
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(a: WebView) {
        a.webViewClient = WebViewClient()
        a.apply {
            // enable js
            settings.javaScriptEnabled = true
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            // enable local storage
            settings.domStorageEnabled = true

            // load url
            loadUrl("https://erp.sandipuniversity.com/login/index/student")
        }
    }
}
