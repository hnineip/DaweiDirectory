package com.hnineiphyu.daweidirectory.ui.hotel

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.HotelAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_recycler_hotel.*

/**
 * A simple [Fragment] subclass.
 */
class HotelFragment : Fragment(), HotelAdapter.ClickListenter {

    private lateinit var hotelAdapter: HotelAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var hotelViewModel: HotelViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        hotelAdapter = HotelAdapter()
        recyclerHotel.adapter = hotelAdapter
        recyclerHotel.layoutManager = viewManager
        hotelAdapter.setOnClickListener(this)
        observeViewModelHotel()
    }

    fun observeViewModelHotel() {

        hotelViewModel = ViewModelProviders.of(this)
            .get(HotelViewModel::class.java)

        hotelViewModel.loadResults()

        hotelViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerHotel.visibility = View.VISIBLE
                hotelAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        hotelViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorHotel.visibility = View.VISIBLE
                    recyclerHotel.visibility = View.GONE
                } else {
                    txtErrorHotel.visibility = View.GONE
                }
            }
        )

        hotelViewModel.getLoading()
            .observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
                loadingViewHotel.visibility = if (isLoading)
                    View.VISIBLE else View.INVISIBLE

                if (isLoading) {
                    txtErrorHotel.visibility = View.GONE
                    recyclerHotel.visibility = View.GONE
                }
            })
        }

    override fun OnClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)

            view!!.findNavController()
                .navigate(R.id.action_navigation_hotel_to_navigation_detail_hotel)
        }
    }
}
