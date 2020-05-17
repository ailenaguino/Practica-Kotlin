package com.example.practica.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadolibreAPI {
    @GET("items/{itemId}")
    fun getProducto (@Path("{itemId}") itemId:String): Call<Producto>
}