package com.hnineiphyu.daweidirectory.ui.restruant

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.RestruantAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.ui.restruantdetail.SelectedDetailViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import kotlinx.android.synthetic.main.fragment_restruant_recycler.*

class RestruantFragment : Fragment(), RestruantAdapter.ClickListenter {


    private lateinit var restruantAdapter: RestruantAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var restruantViewModel: RestruantViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel

//    lateinit var categoryKey: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
        val root = inflater.inflate(R.layout.fragment_restruants, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        restruantAdapter = RestruantAdapter()
        recyclerRestruant.adapter = restruantAdapter
        recyclerRestruant.layoutManager = viewManager
        restruantAdapter.setOnClickListener(this)
        observeViewModel()
    }

    fun observeViewModel() {

        restruantViewModel = ViewModelProviders.of(this)
            .get(RestruantViewModel::class.java)

        selectedCategoryViewModel = ViewModelProviders.of(this)
            .get(SelectedCategoryViewModel::class.java)

        selectedCategoryViewModel.getSelectedCategory().observe(
            viewLifecycleOwner, Observer {category ->
//                categoryKey = category.key.toString()
                restruantViewModel.loadResults(category.key.toString())
                Log.d("Category", category.toString())
            }
        )

        restruantViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerRestruant.visibility = View.VISIBLE
                restruantAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        restruantViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtError.visibility = View.VISIBLE
                    recyclerRestruant.visibility = View.GONE
                } else {
                    txtError.visibility = View.GONE
                }
            }
        )

        restruantViewModel.getLoading()
            .observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
                if (isLoading) {
                    loadingView.visibility = if (isLoading)
                        View.VISIBLE else View.INVISIBLE

                    if (isLoading) {
                        txtError.visibility = View.GONE
                        recyclerRestruant.visibility = View.GONE
                    }
                }
            })
    }

    override fun onClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)
            view!!.findNavController()
                .navigate(R.id.action_navigation_restruant_to_navigation_detail_restruant)
        }
    }
}

//    override fun onResume() {
//        super.onResume()
//        restruantViewModel.loadResults()
//    }
