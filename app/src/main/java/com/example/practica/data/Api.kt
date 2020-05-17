package com.example.practica.data

import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Api {

    //devuelve cualquier cosa que implemente a la interfaz de mercadolibreapi
    private fun getApi():MercadolibreAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(MercadolibreAPI::class.java)
    }

    fun getProducto(id:String, callback: Callback<Producto>){
        getApi().getProducto(id).enqueue(callback)
    }
}