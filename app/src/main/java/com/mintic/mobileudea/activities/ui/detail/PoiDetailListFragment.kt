package com.mintic.mobileudea.activities.ui.detail


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
import com.mintic.mobileudea.activities.ui.poilist.PoiListFragment
import com.mintic.mobileudea.adapter.PoiAdapter
import com.mintic.mobileudea.adapter.PoiDetailAdapter
import com.mintic.mobileudea.model.PoiDetailModel
import com.mintic.mobileudea.model.PoiModel
import com.mintic.mobileudea.viewmodel.PoiDetailViewModel

class PoiDetailFragment : Fragment() {


    private lateinit var mPoiDetail: MutableList<PoiDetailModel>
    private lateinit var mAdapter: PoiDetailAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: PoiDetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poi_detail_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.detail_list)
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this).get(PoiDetailViewModel::class.java)
        model.poiDetailLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.updatePoiDetail(it)
        })
        setupRecyclerView()
        //generatePois()
    }

    private fun setupRecyclerView() {
        mPoiDetail = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        mAdapter = PoiDetailAdapter(mPoiDetail){poiDetail -> poiDetailOnClick(poiDetail)  }

        recycler.adapter = mAdapter
    }
    private fun poiDetailOnClick(poiDetail: PoiDetailModel) {
        Log.d(PoiDetailFragment.TAG, "Click on: $poiDetail")


    }
    companion object {
        private val TAG = PoiListFragment::class.java.simpleName
    }

}

