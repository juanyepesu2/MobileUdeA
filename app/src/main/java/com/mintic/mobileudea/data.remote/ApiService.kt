package com.mintic.mobileudea.data.remote

import com.mintic.mobileudea.model.PoiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

   @GET("poi")
   suspend fun requestPoi(): List<PoiModel>

   //@GET("juanyepesu2/MobileUdeA/")
   //suspend fun requestPoi(@Path(value = "poi") users: String): User

}
