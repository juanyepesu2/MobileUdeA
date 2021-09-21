package com.mintic.mobileudea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        val (poi_name, poi_description, poi_rating, poi_url_image) = mPoi[position]
        holder.poi_nameLabel.text = poi_name
        holder.poi_descriptionLabel.text = poi_description
        holder.poi_ratingLabel.text = poi_rating
        Picasso.get().load(poi_url_image).into(holder.poi_imagecity)
        holder.poi_ratingBar.rating = (poi_rating.toFloat() - 1) / 4
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poi_nameLabel: TextView = itemView.findViewById(R.id.textview_poi_name)
        var poi_ratingLabel: TextView = itemView.findViewById(R.id.textview_poi_rating)
        var poi_descriptionLabel: TextView = itemView.findViewById(R.id.textview_poi_description)
        var poi_imagecity: ImageView = itemView.findViewById(R.id.poi_image)
        var poi_ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }
}




