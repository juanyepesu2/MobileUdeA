package com.mintic.mobileudea.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.model.PoiDetailModel
import com.mintic.mobileudea.model.PoiModel
import com.squareup.picasso.Picasso

class PoiDetailAdapter(

    private var mPoiDetail: MutableList<PoiDetailModel>,


    ) : RecyclerView.Adapter<PoiDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mPoiDetail[position])
    }

    override fun getItemCount(): Int {
        return 1
    }

    fun updatePoiDetail(pois: List<PoiDetailModel>?) {
        this.mPoiDetail.clear()
        pois?.let { this.mPoiDetail.addAll(it) }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poi_nameLabel: TextView = itemView.findViewById(R.id.textview_poi_name)
        var poi_ratingLabel: TextView = itemView.findViewById(R.id.textview_poi_rating)
        var poi_descriptionLabel: TextView = itemView.findViewById(R.id.textview_poi_description)
        var poi_imagecity: ImageView = itemView.findViewById(R.id.poi_image)
        var poi_ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)

        private var currentPoi: PoiModel? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {

                }
            }
        }

        fun bind(point: PoiDetailModel) {
            poi_nameLabel.text = point.poiname
            poi_descriptionLabel.text = point.poidescripcion
            poi_ratingLabel.text = point.poirating
            Picasso.get().load(point.poiimage).into(poi_imagecity)
            poi_ratingBar.rating = (point.poirating.toFloat() - 1) / 5
        }
    }}