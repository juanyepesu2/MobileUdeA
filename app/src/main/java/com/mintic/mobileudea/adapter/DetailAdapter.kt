package com.mintic.mobileudea.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.model.PoiModel
import com.squareup.picasso.Picasso

class DetailAdapter(

    private var mPoi: MutableList<PoiModel>,
    private var MiImagen: String,
    private var MiMapa: String,
    private var miimageView: ImageView,


) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.detail_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mPoi[position])
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    fun updateDetailList(pois: List<PoiModel>?) {
        //this.mPoi.clear()
        pois?.let { this.mPoi.addAll(it) }
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.name_POIs)
        var intro1View : TextView = view.findViewById(R.id.description1_POIs)
        var intro2View : TextView = view.findViewById(R.id.description2_POIs)
        var localizationView : TextView = view.findViewById(R.id.location_value)
        var temperatureView : TextView = view.findViewById(R.id.temperature_value)
        var placesView : TextView = view.findViewById(R.id.places_interest)
        var miimageView : ImageView= view.findViewById(R.id.image_POIs)

        private var currentPoi: PoiModel? = null

         fun bind(point: PoiModel) {
            currentPoi = point
            name.text = point.poiname
            intro1View.text = point.poiimage
            intro2View.text = point.poidescription2
            intro2View.isVisible = false
            localizationView.text = point.poilocalization
            temperatureView.text = point.poitemperature
            placesView.text = point.poiplaces
            MiImagen = point.poiimage
            Picasso.get()
                .load(MiImagen)
                .error(R.mipmap.ic_launcher_round)
                .resize(3500, 1400)
                .into(miimageView)
            MiMapa = point.poimap
            }
    }
}
