package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //
        btnVolver.setOnClickListener{finish()}
        //recibir parametros desde otra activity -- A textParametro asignale intent......
        textParametro.text = intent.extras?.getString(PARAMETRO_PRINCIPAL, "")

        btnIrAPicasso.setOnClickListener {
            val intent = Intent(this, Retrofit::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        //especie de notificacion que aparece abajo
        Snackbar.make(LyActivity3, getString(R.string.esta_accion_no_se_puede_realizar),
            Snackbar.LENGTH_LONG).show()
    }

    companion object{
        val PARAMETRO_PRINCIPAL:String = "Parametro principal"
    }
}
