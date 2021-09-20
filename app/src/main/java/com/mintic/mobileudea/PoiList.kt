package com.mintic.mobileudea

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.util.ArrayList
import org.json.JSONArray
import org.json.JSONException

class PoiList : AppCompatActivity() {

    private lateinit var mPoi: ArrayList<Poi>
    private lateinit var mAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_list)
        recycler = findViewById(R.id.poi_list)
        setupRecyclerView()
        generateContacts()
    }
    /**
     * Sets up the RecyclerView: empty data set, item dividers, swipe to delete.
     */
    private fun setupRecyclerView() {
        mPoi = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = PoiAdapter(mPoi)
        recycler.adapter = mAdapter
    }
    /**
     * Generates mock contact data to populate the UI from a JSON file in the
     * assets directory, called from the options menu.
     */
    private fun generateContacts() {
        val contactsString = readContactJsonFile()
        try {
            val contactsJson = JSONArray(contactsString)
            for (i in 0 until contactsJson.length()) {
                val contactJson = contactsJson.getJSONObject(i)
                val poi = Poi(
                    contactJson.getString("poi_name"),
                    contactJson.getString("poi_description"),
                    contactJson.getString("poi_raiting"),
                    contactJson.getString("poi_image")
                )
                Log.d(TAG, "generatePoi: $poi")
                mPoi.add(poi)
            }
            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    /**
     * Reads a file from the assets directory and returns it as a string.
     *
     * @return The resulting string.
     */
    private fun readContactJsonFile(): String? {
        var poiString: String? = null
        try {
            val inputStream = assets.open("poi.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            poiString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return poiString
    }
    companion object {
        private val TAG = PoiList::class.java.simpleName
    }
}