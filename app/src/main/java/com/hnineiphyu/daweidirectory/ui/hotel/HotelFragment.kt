package com.hnineiphyu.daweidirectory.ui.hotel


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.HotelAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.MainCategory
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_recycler_hotel.*

/**
 * A simple [Fragment] subclass.
 */
class HotelFragment : Fragment(), HotelAdapter.ClickListenter {

    private lateinit var hotelAdapter: HotelAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewManager = LinearLayoutManager(activity)
//        hotelAdapter = HotelAdapter()
//        recyclerHotel.adapter = hotelAdapter
//        recyclerHotel.layoutManager = viewManager
//        hotelAdapter.setOnClickListener(this)
//        observeViewModelEducation()
//    }
//
//    fun observeViewModelEducation() {
//
//        categoryViewModel = ViewModelProviders.of(this)
//            .get(CategoryViewModel::class.java)
//
//        categoryViewModel.loadResults()
//
//        categoryViewModel.getResult().observe(
//            viewLifecycleOwner, Observer<ResponseInfos> { result ->
//
//                recyclerHotel.visibility = View.VISIBLE
//                hotelAdapter.updateList(result.infos as List<InfosItem>)
//
//            }
//        )
//
//        categoryViewModel.getErrors().observe(
//            viewLifecycleOwner, Observer<Boolean> { isError ->
//
//                if(isError){
//                    txtErrorHotel.visibility = View.VISIBLE
//                    recyclerHotel.visibility = View.GONE
//                }
//                else{
//                    txtErrorHotel.visibility = View.GONE
//                }
//            }
//        )
//
//        categoryViewModel.getLoading().observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
//            if(isLoading){
//                loadingViewHotel.visibility = if(isLoading)
//                    View.VISIBLE else View.INVISIBLE
//
//                if(isLoading){
//                    txtErrorHotel.visibility = View.GONE
//                    recyclerHotel.visibility = View.GONE
//                }
//            }
//        })
//    }

    override fun OnClick(infosItem: InfosItem) {

    }
}
