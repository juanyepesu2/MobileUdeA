package com.mintic.mobileudea.model

import com.google.gson.annotations.SerializedName

data class PoiDetailModel (
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

    )