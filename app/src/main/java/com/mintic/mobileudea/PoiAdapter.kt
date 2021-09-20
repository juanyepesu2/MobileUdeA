package com.mintic.mobileudea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PoiAdapter(
    private val mPoi: ArrayList<Poi>
) : RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.poi_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (poi_name, poi_description, poi_rating) = mPoi[position]
        holder.poi_nameLabel.text = poi_name
        holder.poi_descriptionLabel.text = poi_description
        holder.poi_raitingLabel.text = poi_rating
        // Esa formula es una transformación lineal para que si el rating del POI es
        // 5 se complete toda la estrella (1); y si es 1, no se complete nada.
        holder.poi_ratingBar.rating = (poi_rating.toFloat() - 1) / 4
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poi_nameLabel: TextView = itemView.findViewById(R.id.textview_poi_name)
        var poi_raitingLabel: TextView = itemView.findViewById(R.id.textview_poi_raiting)
        var poi_descriptionLabel: TextView = itemView.findViewById(R.id.textview_poi_description)
        var poi_ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    // Para cargar las imagenes en el RecyclerView:

}