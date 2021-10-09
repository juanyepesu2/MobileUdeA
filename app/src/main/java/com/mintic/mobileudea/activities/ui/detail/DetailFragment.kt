package com.mintic.mobileudea.activities.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.activities.ui.poilist.PoiListFragment
import com.mintic.mobileudea.adapter.PoiAdapter
import com.mintic.mobileudea.adapter.PoiDetailAdapter
import com.mintic.mobileudea.databinding.FragmentDetailBinding
import com.mintic.mobileudea.model.PoiModel
import com.mintic.mobileudea.viewmodel.PoiDetailViewModel
import com.mintic.mobileudea.viewmodel.PoiViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var model: PoiDetailViewModel
    private lateinit var nameView: TextView
    private lateinit var intro1View: TextView
    private lateinit var intro2View: TextView
    private lateinit var localizationView: TextView
    private lateinit var temperatureView: TextView
    private lateinit var placesView: TextView
    private lateinit var miimageView: ImageView
    private lateinit var MiImagen: String
    private lateinit var MiMapa: String
    private lateinit var poi: PoiModel
    var estadoboton: Boolean = true

    private lateinit var mPoiDetail: MutableList<PoiModel>
    private lateinit var mPoiDetailAdapter: PoiDetailAdapter
    private lateinit var recycler: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.detail)
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this).get(PoiDetailViewModel::class.java)
        model.poiDetailLiveData.observe(viewLifecycleOwner, Observer {
            mPoiDetailAdapter.updatePoiDetail(it)
        })
        setupRecyclerView()
        //generatePois()
    }

    private fun setupRecyclerView() {
/*
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
 */
        recycler.adapter = mPoiDetailAdapter


    }
}

