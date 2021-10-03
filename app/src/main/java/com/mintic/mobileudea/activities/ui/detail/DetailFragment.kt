package com.mintic.mobileudea.activities.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mintic.mobileudea.R
import com.mintic.mobileudea.databinding.FragmentDetailBinding
import com.mintic.mobileudea.viewmodel.PoiViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    private lateinit var model: PoiViewModel
    private lateinit var nameView: TextView
    private lateinit var intro1View: TextView
    private lateinit var intro2View: TextView
    private lateinit var localizationView: TextView
    private lateinit var temperatureView: TextView
    private lateinit var placesView: TextView
    private lateinit var miimageView: ImageView
    private lateinit var MiImagen: String
    var estadoboton: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        detailViewModel =
            ViewModelProvider(this).get(DetailViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        view.findViewById<Button>(R.id.button_ver_mas).setOnClickListener {
            if (estadoboton == true) {
                view.findViewById<Button>(R.id.button_ver_mas).text = ("Leer Menos")
                view.findViewById<TextView>(R.id.description2_POIs).isVisible = true
                estadoboton = false
            } else {
                view.findViewById<Button>(R.id.button_ver_mas).text = ("Leer Más")
                estadoboton = true
                view.findViewById<TextView>(R.id.description2_POIs).isVisible = false
            }
        }
        view.findViewById<Button>(R.id.button_info).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_detailFragment4_to_poiListFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameView = view.findViewById(R.id.name_POIs)
        intro1View = view.findViewById(R.id.description1_POIs)
        intro2View = view.findViewById(R.id.description2_POIs)
        localizationView = view.findViewById(R.id.location_value)
        temperatureView = view.findViewById(R.id.temperature_value)
        placesView = view.findViewById(R.id.places_interest)
        miimageView = view.findViewById(R.id.image_POIs)
        model = ViewModelProvider(requireActivity()).get(PoiViewModel::class.java)
        observeLiveData()
    }

    private fun observeLiveData() {
        model.getSelected().observe(viewLifecycleOwner, { poi ->
            nameView.text = poi.poi_name
            intro1View.text = poi.poi_description1
            intro2View.text = poi.poi_description2
            intro2View.isVisible = false
            localizationView.text = poi.poi_localization
            temperatureView.text = poi.poi_temperature
            placesView.text = poi.poi_places
            MiImagen = poi.poi_image
            Picasso.get()
                .load(MiImagen)
                .error(R.mipmap.ic_launcher_round)
                .resize(3500, 1400)
                .into(miimageView)
        })
    }
}

