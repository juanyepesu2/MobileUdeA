package com.mintic.mobileudea.viewmodel

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mintic.mobileudea.R
import com.mintic.mobileudea.adapter.PoiAdapter
import com.mintic.mobileudea.data.remote.RetrofitFactory
import com.mintic.mobileudea.model.PoiModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PoiViewModel : ViewModel() {
    private val selected = MutableLiveData<PoiModel>()
    fun getSelected(): LiveData<PoiModel> = selected
    fun select (poi: PoiModel) {
        selected.value = poi
    }

    private var apiService = RetrofitFactory.apiService()
    private var poi = MutableLiveData<List<PoiModel>>()
    var poiLiveData: LiveData<List<PoiModel>> = poi

    init {
        getPoi()

    }

    fun getPoi() {
        viewModelScope.launch {
            poi.value = requestPoi()
        }
    }

    private suspend fun requestPoi(): List<PoiModel> {
        return withContext(Dispatchers.IO) {
            apiService.requestPoi()
             }
}
}