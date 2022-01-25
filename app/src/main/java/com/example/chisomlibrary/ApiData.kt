package com.example.chisomlibrary

import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("version") val version: Int,
    @SerializedName("text") val text: String,
    @SerializedName("requestParams") val requestParams: Array<String>
    )
