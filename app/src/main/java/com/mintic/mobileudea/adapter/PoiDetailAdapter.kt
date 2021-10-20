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
import com.mintic.mobileudea.viewmodel.PoiViewModel
import com.squareup.picasso.Picasso

class PoiDetailAdapter(

    private var mPoiDetail: MutableList<PoiDetailModel>,

    private val onClick: (PoiDetailModel) -> Unit,

    ) : RecyclerView.Adapter<PoiDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.poi_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mPoiDetail[position])
    }

    override fun getItemCount(): Int {
        print("El tamaño de la lista es:"+mPoiDetail.size.toString())
        return mPoiDetail.size


    }

    fun updatePoiDetail(poiDetails: List<PoiDetailModel>?,position: Int) {
        this.mPoiDetail.clear()
        val num = arrayOf<PoiDetailModel>(poiDetails!!.elementAt(1))
        poiDetails?.let { this.mPoiDetail.addAll(num) }
        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poi_nameLabel: TextView = itemView.findViewById(R.id.textview_poi_name)
        var poi_descriptionLabel: TextView = itemView.findViewById(R.id.textview_poi_description)
        var poi_imagecity: ImageView = itemView.findViewById(R.id.poi_image)

        private var currentPoi: PoiDetailModel? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {
                    onClick(it)
                }
            }
        }


        fun bind(point: PoiDetailModel) {

            currentPoi = point
            poi_nameLabel.text = point.poiname
            poi_descriptionLabel.text = point.poidescripcion
            Picasso.get().load(point.poiimage).into(poi_imagecity)

        }
    }

    }