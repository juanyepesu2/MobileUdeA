package com.mintic.mobileudea.activities.ui.poilist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.mintic.mobileudea.R
import com.mintic.mobileudea.adapter.PoiAdapter
import com.mintic.mobileudea.model.PoiModel
import com.mintic.mobileudea.viewmodel.PoiViewModel
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class PoiListFragment : Fragment() {

    private lateinit var mPoi: MutableList<PoiModel>
    private lateinit var mAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: PoiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.poi_list)
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this).get(PoiViewModel::class.java)
        model.poiLiveData.observe(viewLifecycleOwner, Observer {
        mAdapter.updatePoiList(it)
        })
        setupRecyclerView()
        //generatePois()
    }

    private fun setupRecyclerView() {
        mPoi = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        mAdapter = PoiAdapter(mPoi) { poi ->
            poiOnClick(poi)
        }

        recycler.adapter = mAdapter
    }

    private fun poiOnClick(poi: PoiModel) {
        Log.d(TAG, "Click on: $poi")
        model.select(poi)
        findNavController().navigate(R.id.action_poiListFragment_to_detailFragment4)
    }

/* private fun generatePois() {
     val poisString = readPoiJsonFile()
     try {
         val PoiJson = JSONArray(poisString)
         for (i in 0 until PoiJson.length()) {
             val poiJson = PoiJson.getJSONObject(i)
             val poi = PoiModel(
                 poiJson.getString("poi_name"),
                 poiJson.getString("poi_description"),
                 poiJson.getString("poi_rating"),
                 poiJson.getString("poi_image"),
                 poiJson.getString("poi_description1"),
                 poiJson.getString("poi_description2"),
                 poiJson.getString("poi_localization"),
                 poiJson.getString("poi_temperature"),
                 poiJson.getString("poi_places"),
                 poiJson.getString("poi_map")
             )
             mPoi.add(poi)
         }
         mAdapter.notifyDataSetChanged()
     } catch (e: JSONException) {
         e.printStackTrace()
     }
 }*/

/* private fun readPoiJsonFile(): String? {
     var poiString: String? = null
     try {
         val inputStream = requireContext().assets.open("poi.json")
         val size = inputStream.available()
         val buffer = ByteArray(size)
         inputStream.read(buffer)
         inputStream.close()
         poiString = String(buffer)
     } catch (e: IOException) {
         e.printStackTrace()
     }
     return poiString
 }*/

 companion object {
     private val TAG = PoiListFragment::class.java.simpleName
 }
}

