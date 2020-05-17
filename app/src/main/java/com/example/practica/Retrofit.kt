package com.example.practica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practica.data.Api
import com.example.practica.data.Persona
import com.example.practica.data.Producto
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Retrofit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        /*
        Picasso.get()
            .load("https://i.blogs.es/ba4666/emele/1366_2000.jpg")
            .centerCrop()
            .fit()
            .into(imgImagen)

        //convierto objeto (persona) a Json
        val gson = Gson();
        val persona = Persona("Ailen", "Aguino")
        val personaJson = gson.toJson(persona);

        //convertir un json a un objeto
        val stringJson = "{\"nombre\":\"Ailen\",\"apellido\":\"Aguino\"}"
        val persona2 = gson.fromJson(stringJson , Persona::class.java)*/

        btnBuscar.setOnClickListener{buscar()}
    }

    private fun buscar(){

        Api().getProducto(editTextBuscar.editText?.text.toString(), object:Callback<Producto>{
            override fun onFailure(call: Call<Producto>, t: Throwable) {
                Toast.makeText(this@Retrofit, "Ocurrió un error", Toast.LENGTH_LONG)
                    .show()
            }
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Producto>, response: Response<Producto>) {
                if (response.isSuccessful) {
                    val producto = response.body()
                    txtTitulo.text = "Titulo: ${producto?.title}"
                    txtPrecio.text = "Precio: ${producto?.price}"
                    Picasso.get()
                        .load("${producto?.thumbnail}")
                        .centerCrop()
                        .fit()
                        .into(imgImagen)
                }else{
                    Toast.makeText(this@Retrofit, "Item no encontrado", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}
