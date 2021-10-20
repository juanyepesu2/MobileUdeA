package com.mintic.mobileudea

import com.mintic.mobileudea.model.Poi
import org.junit.Test

import org.junit.Assert.*

class PoiUnitTest {
    @Test
    fun poi_defined() {
        val poi_variable = Poi(
            "Cristo Rey",
            "Es un cristo ubicado en la ciudad de Cali",
            "4.2",
            "https://www.cali.gov.co/gobierno/info/principal/media/pubInt/thumbs/thpub_700x400_155052.jpg",
            "Descripcion de test1",
            "Descipcion de test2",
            "Cali - Valle del Cauca",
            "25° en promedio",
            "Iglesia del divino niño, otros",
            "123123123.123 123234.231"
        )
        assertTrue(poi_variable is Poi)


    }
}