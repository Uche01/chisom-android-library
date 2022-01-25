package com.example.chisomlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var btnApiCall: Button
    lateinit var btnDisplayWebview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lib = LibrayClass("https://asdfast.beobit.net/api/", "https://google.com")

        btnApiCall = findViewById(R.id.btnApi)
        btnDisplayWebview = findViewById(R.id.btnWebview)

        btnApiCall.setOnClickListener {

            lifecycleScope.launch {
                try {
                    val data = lib.makeAsyncCall()
                    Log.d("res", data.text)
                    Toast.makeText(this@MainActivity, data.text, Toast.LENGTH_LONG).show()
                }
                catch (e: Exception) {
                    Toast.makeText(this@MainActivity, "Request failed", Toast.LENGTH_LONG).show()
                }
            }

        }

        btnDisplayWebview.setOnClickListener {
            val url = lib.webViewurl
            lib.displayWebview(this, url)
        }
    }
}