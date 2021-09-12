package com.mintic.mobileudea

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class SitioAdapter(private val mContext: Context, private val listaSitios: List<Sitio>): ArrayAdapter<Sitio>(mContext, 0, listaSitios) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_sitio, parent, false)
        val sitio = listaSitios[position]



        return layout
    }


}