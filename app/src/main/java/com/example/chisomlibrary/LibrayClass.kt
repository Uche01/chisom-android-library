package com.example.chisomlibrary

import android.content.Context
import android.content.Intent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


class LibrayClass(val asyncApiEndpoint: String, val webViewurl: String) {

    suspend fun makeAsyncCall(): ApiData {

        val retrofit = Retrofit.Builder()
            .baseUrl(asyncApiEndpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ApiService = retrofit.create(ApiService::class.java)

        try {
            return service.getData()
        }
        catch (e: Exception) {
            throw e
        }
    }

    fun displayWebview(context: Context, url: String) {
        val intent = Intent(context, WebviewActivity::class.java)
        intent.putExtra("url", url)
        context.startActivity(intent)
    }
}