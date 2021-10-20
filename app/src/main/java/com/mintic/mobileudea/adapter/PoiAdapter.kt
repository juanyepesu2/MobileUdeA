package com.mintic.mobileudea.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.model.PoiModel
import com.squareup.picasso.Picasso

class PoiAdapter(

    private var mPoi: MutableList<PoiModel>,
    private val onClick: (PoiModel) -> Unit,

    ) : RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.poi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mPoi[position])
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    fun updatePoi(pois: List<PoiModel>?) {
        this.mPoi.clear()
        pois?.let { this.mPoi.addAll(it) }
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
                    onClick(it)
                }
            }
        }

        fun bind(point: PoiModel) {
            currentPoi = point
            poi_nameLabel.text = point.poiname
            poi_descriptionLabel.text = point.poidescripcion
            poi_ratingLabel.text = point.poirating
            Picasso.get().load(point.poiimage).into(poi_imagecity)
            poi_ratingBar.rating = (point.poirating.toFloat() - 1) / 5
        }
    }

    /// versión original
    /*private val mPoi: ArrayList<PoiModel>,
    private val onClick: (PoiModel) -> Unit,

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

        private var currentPoi: PoiModel? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {
                    onClick(it)
                }
            }
        }

        fun bind(point: PoiModel) {
            currentPoi = point
            poi_nameLabel.text = point.poi_name
            poi_descriptionLabel.text = point.poi_description
            poi_ratingLabel.text = point.poi_rating
            Picasso.get().load(point.poi_image).into(poi_imagecity)
            poi_ratingBar.rating = (point.poi_rating.toFloat() - 1) / 5
        }
    }*/

//Ejercicio profesor
/*    private val clickListener: OnItemClickListener
) :
    RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    // private var deletedPostPosition: Int = 0
    //private lateinit var deletedPost: Post
    private var postList = mutableListOf<Post>()

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poi_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.dot.visibility = View.VISIBLE
        holder.contentView.text = post.title
    }

    override fun getItemCount() = postList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dot: TextView = view.blue_dot
        val contentView: TextView = view.content

        init {
            view.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    fun updatePostList(posts: List<Post>?) {
        this.postList.clear()
        posts?.let { this.postList.addAll(it) }
        notifyDataSetChanged()
    }*/

}
