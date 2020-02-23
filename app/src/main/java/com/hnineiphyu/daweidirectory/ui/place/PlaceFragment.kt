package com.hnineiphyu.daweidirectory.ui.place

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.PlaceAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_recycler_place.*

/**
 * A simple [Fragment] subclass.
 */
class PlaceFragment : Fragment(), PlaceAdapter.ClickListenter {

    private lateinit var placeAdapter: PlaceAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var placeViewModel: PlaceViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = GridLayoutManager(activity, 2)
        placeAdapter = PlaceAdapter()
        recyclerPlace.adapter = placeAdapter
        recyclerPlace.layoutManager = viewManager
        placeAdapter.setOnClickListener(this)
        observeViewModelPlace()
    }

    fun observeViewModelPlace() {

        placeViewModel = ViewModelProviders.of(this)
            .get(PlaceViewModel::class.java)

        placeViewModel.loadResults()

        placeViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerPlace.visibility = View.VISIBLE
                placeAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        placeViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorPlace.visibility = View.VISIBLE
                    recyclerPlace.visibility = View.GONE
                } else {
                    txtErrorPlace.visibility = View.GONE
                }
            }
        )

        placeViewModel.getLoading().observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->

                loadingViewPlace.visibility = if (isLoading)
                    View.VISIBLE else View.INVISIBLE

                if (isLoading) {
                    txtErrorPlace.visibility = View.GONE
                    recyclerPlace.visibility = View.GONE
                }
             })
        }

    override fun OnClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)

            view!!.findNavController()
                .navigate(R.id.action_navigation_place_to_navigation_place_detail)
        }
    }
}
