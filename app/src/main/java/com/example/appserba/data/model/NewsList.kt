package com.example.appserba.data.model

data class NewsList (
    val results: List<News> = arrayListOf(),
    val method: String = "",
    val status: String = ""
)