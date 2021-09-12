package com.mintic.mobileudea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sitio = Sitio("Memory Lane", R.drawable.calle_recuerdo)
        val sitio2 = Sitio("Parish Church of Nuestra Señora del Carmen", R.drawable.parish_church)
        val sitio3 = Sitio("Zocalo town", R.drawable.otro)

        val listaSitio = listOf(sitio, sitio2, sitio3)

        val adapter = SitioAdapter(this, listaSitio)

        val lista_sitios: ListView = findViewById(R.id.lista_sitios)
        lista_sitios.adapter = adapter

    }
}
