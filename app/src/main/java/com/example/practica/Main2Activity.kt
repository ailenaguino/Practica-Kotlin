package com.example.practica

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnCambiarColor.setOnClickListener{onColorChangeClick()}
        btnIrNuevoActivity.setOnClickListener{
            /*Toda Activity necesita un intent, en este caso el Intent debería tener la activity a la que quiero ir
            Las activity heredan de Context
            startActivity(Intent(this, Main3Activity::class.java))*/
            val intent = Intent(this, Main3Activity::class.java)
            intent.putExtra(Main3Activity.PARAMETRO_PRINCIPAL, parametroParaPasar.editText?.text.toString())
            startActivity(intent)
        }
    }

    private fun onColorChangeClick(){
        when(editTextColor.editText?.text.toString().toLowerCase().trim()){
            "green" -> colorParaCambiar.setBackgroundColor(ContextCompat.getColor(this,R.color.green))
            "orange" -> colorParaCambiar.setBackgroundColor(ContextCompat.getColor(this,R.color.orange))
            else -> colorParaCambiar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))
        }
    }

}
