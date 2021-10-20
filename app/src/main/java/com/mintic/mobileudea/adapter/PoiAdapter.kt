package com.mintic.mobileudea.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.model.Poi
import com.squareup.picasso.Picasso
import java.util.*

class PoiAdapter(
    private val mPoi: ArrayList<Poi>,
    private val onClick: (Poi) -> Unit,

    ) : RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.poi_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(mPoi[position])
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

        private var currentPoi: Poi? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {
                    onClick(it)
                }
            }
        }

        fun bind(point: Poi) {
            currentPoi = point
            poi_nameLabel.text = point.poi_name
            poi_descriptionLabel.text = point.poi_description
            poi_ratingLabel.text = point.poi_rating
            Picasso.get().load(point.poi_image).into(poi_imagecity)
            poi_ratingBar.rating = (point.poi_rating.toFloat() - 1) / 5
        }
    }
}
