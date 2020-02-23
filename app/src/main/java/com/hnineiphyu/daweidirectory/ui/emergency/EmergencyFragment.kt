package com.hnineiphyu.daweidirectory.ui.emergency


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.EmergencyAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_recycler_emergency.*
import kotlinx.android.synthetic.main.item_emergency.*

/**
 * A simple [Fragment] subclass.
 */
class EmergencyFragment : Fragment(), EmergencyAdapter.ClickListenter {

    private lateinit var emergencyAdapter: EmergencyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var emergencyViewModel: EmergencyViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emergency, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        emergencyAdapter = EmergencyAdapter()
        recyclerEmergency.adapter = emergencyAdapter
        recyclerEmergency.layoutManager = viewManager
        emergencyAdapter.setOnClickListener(this)
        observeViewModelEmergency()
    }

    fun observeViewModelEmergency() {

        emergencyViewModel = ViewModelProviders.of(this)
            .get(EmergencyViewModel::class.java)

        emergencyViewModel.loadResults()

        emergencyViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerEmergency.visibility = View.VISIBLE
                emergencyAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        emergencyViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorEmergency.visibility = View.VISIBLE
                    recyclerEmergency.visibility = View.GONE
                } else {
                    txtErrorEmergency.visibility = View.GONE
                }
            }
        )

        emergencyViewModel.getLoading().observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->

            loadingViewEmergency.visibility = if (isLoading)
                View.VISIBLE else View.INVISIBLE

            if (isLoading) {
                txtErrorEmergency.visibility = View.GONE
                recyclerEmergency.visibility = View.GONE
            }
        })



    }

    override fun OnClick(infosItem: InfosItem) {
    }
}
