package com.hnineiphyu.daweidirectory.ui.bank

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
import com.hnineiphyu.daweidirectory.adapter.BankAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_recycler_bank.*

/**
 * A simple [Fragment] subclass.
 */
class BankFragment : Fragment(), BankAdapter.ClickListenter {

    private lateinit var bankAdapter: BankAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var bankViewModel: BankViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        bankAdapter = BankAdapter()
        recyclerBank.adapter = bankAdapter
        recyclerBank.layoutManager = viewManager
        bankAdapter.setOnClickListener(this)
        observeViewModel()
    }

    fun observeViewModel() {

        bankViewModel = ViewModelProviders.of(this)
            .get(BankViewModel::class.java)

        bankViewModel.loadResults()

        bankViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerBank.visibility = View.VISIBLE
                bankAdapter.updateList(result.infos as List<InfosItem>)

            }
        )
            bankViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorBank.visibility = View.VISIBLE
                    recyclerBank.visibility = View.GONE
                } else {
                    txtErrorBank.visibility = View.GONE
                }
            }
        )

        bankViewModel.getLoading()
            .observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->

                    loadingViewBank.visibility = if (isLoading)
                        View.VISIBLE else View.INVISIBLE

                    if (isLoading) {
                        txtErrorBank.visibility = View.GONE
                        recyclerBank.visibility = View.GONE
                    }
            })
        }

    override fun OnClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)

            view!!.findNavController()
                .navigate(R.id.action_navigation_bank_to_navigation_bank_detail)
        }
    }
}
