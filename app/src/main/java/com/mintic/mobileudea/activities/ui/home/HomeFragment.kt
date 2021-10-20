package com.mintic.mobileudea.activities.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mintic.mobileudea.R
import com.mintic.mobileudea.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<Button>(R.id.button_settings).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_titleFragment_to_settingsFragment)
        }
        view.findViewById<Button>(R.id.button_ini).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_titleFragment_to_poiListFragment)
        }
        setHasOptionsMenu(true)
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
