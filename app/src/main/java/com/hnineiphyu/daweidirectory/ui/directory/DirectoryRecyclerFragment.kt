package com.hnineiphyu.daweidirectory.ui.directory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.MainCategoryAdapter
import com.hnineiphyu.daweidirectory.model.MainCategory
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel

class DirectoryRecyclerFragment : Fragment(), MainCategoryAdapter.ClickListenter {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_recycler_list, container, false)

        var CategoryRecyclerView = root.findViewById<RecyclerView>(R.id.recycler_list)

        var CategoryList = ArrayList<MainCategory>()

        CategoryList.add(MainCategory(R.drawable.ic_food, "Restaurants", 6))
        CategoryList.add(MainCategory(R.drawable.ic_education, "Education", 11))
        CategoryList.add(MainCategory(R.drawable.iconfinder_hotel, "Hotels", 7))
        CategoryList.add(MainCategory(R.drawable.ic_health, "Health", 12))
        CategoryList.add(MainCategory(R.drawable.ic_bank, "Bank", 9))
        CategoryList.add(MainCategory(R.drawable.ic_fashion, "Fashion", 10))

        var mainCategoryAdapter = MainCategoryAdapter(CategoryList)

        CategoryRecyclerView.layoutManager = GridLayoutManager(context, 2)

        CategoryRecyclerView.adapter = mainCategoryAdapter

        mainCategoryAdapter.setOnClickListener(this)

        return root
    }

    override fun onClick(mainCategory: MainCategory) {
        if (mainCategory.key == 6) {

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_restruant)
        }

        else if(mainCategory.key == 11){

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_education)
        }

        else if(mainCategory.key == 7){

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_hotel)
        }

        else if(mainCategory.key == 12){

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_health)
        }

        else if(mainCategory.key == 9){

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_bank)
        }

        else if(mainCategory.key == 10){

            val selectedcategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedCategoryViewModel::class.java)

            selectedcategoryViewModel.selectedCategory(mainCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_fashion)
        }
    }
}





