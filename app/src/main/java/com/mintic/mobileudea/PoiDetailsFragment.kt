package com.mintic.mobileudea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.navArgs
import com.mintic.mobileudea.databinding.FragmentPoiDetailsBinding

class PoiDetailsFragment : Fragment() {

    private lateinit var binding : FragmentPoiDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poi_details, container, false)



    }



}