package com.zakib.coffeeisgood

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoffeeMastersApiService {
    @GET("menu.json")
    /**
     * suspend ?
     * Coroutines is a new mechanism in Kotlin,to actually make some kind of threading.
     * It's a modern way, it's a different way to work with threading and multitasking.
      */

    suspend fun fetchMenu(): List<Category>
}

object API {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://firtman.github.io/coffeemasters/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val menuService: CoffeeMastersApiService by lazy {
        retrofit.create(CoffeeMastersApiService::class.java)
    }
}