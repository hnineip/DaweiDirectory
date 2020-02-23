package com.hnineiphyu.daweidirectory.ui.fashion


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
import com.hnineiphyu.daweidirectory.adapter.FashionAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_recycler_fashion.*

/**
 * A simple [Fragment] subclass.
 */
class FashionFragment : Fragment(), FashionAdapter.ClickListenter {

    private lateinit var fashionAdapter: FashionAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var fashionViewModel: FashionViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fashion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        fashionAdapter = FashionAdapter()
        recyclerFashion.adapter = fashionAdapter
        recyclerFashion.layoutManager = viewManager
        fashionAdapter.setOnClickListener(this)
        observeViewModelFashion()

    }

    fun observeViewModelFashion() {

        fashionViewModel = ViewModelProviders.of(this)
            .get(FashionViewModel::class.java)

        fashionViewModel.loadResults()

        fashionViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerFashion.visibility = View.VISIBLE
                fashionAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        fashionViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorFashion.visibility = View.VISIBLE
                    recyclerFashion.visibility = View.GONE
                } else {
                    txtErrorFashion.visibility = View.GONE
                }
            }
        )

        fashionViewModel.getLoading().observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
                loadingViewFashion.visibility = if (isLoading)
                    View.VISIBLE else View.INVISIBLE

                if (isLoading) {
                    txtErrorFashion.visibility = View.GONE
                    recyclerFashion.visibility = View.GONE

            }
        })
    }

    override fun OnClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)

            view!!.findNavController()
                .navigate(R.id.action_navigation_fashion_to_navigation_fashion_detail)
        }
    }
}
