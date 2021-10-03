package com.mintic.mobileudea.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mintic.mobileudea.model.Poi

class PoiViewModel : ViewModel() {
    private val selected = MutableLiveData<Poi>()
    fun getSelected(): LiveData<Poi> = selected
    fun select(poi: Poi) {
        selected.value = poi
    }
}