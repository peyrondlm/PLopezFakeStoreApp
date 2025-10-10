package com.example.fakestoreapp.designpattern

import retrofit2.Retrofit

// Singleton - Debes garantizar que solo exista una instancia de la clase
// durante toda la app RetrofitInstance.retrofit

object RetrofitInstance{
    val BASE_URL = "https://fakestoreapi.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
}