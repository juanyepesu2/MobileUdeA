package com.mintic.mobileudea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.navArgs
import com.mintic.mobileudea.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener{
        }

        val boton: Button = findViewById(R.id.ver_mas)
        val descripcion2: TextView = findViewById(R.id.description2)
        descripcion2.isVisible = false
        var estadoboton: Boolean = true
        boton.setOnClickListener {
            if (estadoboton == true) {
                boton.setText("Leer Menos")
                descripcion2.isVisible = true
                estadoboton = false
            } else {
                boton.setText("Leer Más")
                estadoboton = true
                descripcion2.isVisible = false
            }
        }
    }
}