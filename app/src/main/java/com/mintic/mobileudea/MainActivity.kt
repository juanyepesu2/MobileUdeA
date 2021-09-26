package com.mintic.mobileudea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.navArgs
import com.mintic.mobileudea.databinding.ActivityMainBinding
import com.mintic.mobileudea.databinding.FragmentPoiListBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        navController = this.findNavController(R.id.poiListFragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }


    //Initialize the bottom navigation view
        //create bottom navigation view object

    }

