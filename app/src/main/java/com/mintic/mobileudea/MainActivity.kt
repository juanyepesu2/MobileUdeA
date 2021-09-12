package com.mintic.mobileudea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.navArgs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById(R.id.ver_mas)
        val descripcion2: TextView = findViewById(R.id.description2)
        var estadoboton: Boolean = false

         boton.setOnClickListener{
            if (estadoboton == true) {
                boton.setText("Leer Menos")
                val estado: Boolean
                descripcion2.isVisible= true
                estadoboton = false
            } else {
                boton.setText("Leer Más")
                estadoboton = true
                descripcion2.isVisible= false
                }

        }
    }
}