package com.mintic.mobileudea.model

import com.google.gson.annotations.SerializedName

data class PoiModel(

    @SerializedName("poi_name")
    val poiname: String,

    @SerializedName("poi_description")
    val poidescripcion: String,

    @SerializedName("poi_rating")
    val poirating: String,

    @SerializedName("poi_image")
    val poiimage: String,

    @SerializedName("poi_description1")
    val poidescription1: String,

    @SerializedName("poi_description2")
    val poidescription2: String,

    @SerializedName("poi_localization")
    val poilocalization: String,

    @SerializedName("poi_temperature")
    val poitemperature: String,

    @SerializedName("poi_places")
    val poiplaces: String,

    @SerializedName("poi_map")
    val poimap: String,

    // Con Json en la App y no externa
    /*data class PoiModel(
    val poi_name: String,
    val poi_description: String,
    val poi_rating: String,
    val poi_image: String,
    val poi_description1: String,
    val poi_description2: String,
    val poi_localization: String,
    val poi_temperature: String,
    val poi_places: String,
    val poi_map: String,*/
)