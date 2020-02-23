package com.hnineiphyu.daweidirectory.ui.subcategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.SubCategoriesAdapter
import com.hnineiphyu.daweidirectory.model.SubCategories

/**
 * A simple [Fragment] subclass.
 */
class RecyclerSubCategoriesFragment : Fragment(), SubCategoriesAdapter.ClickListenter {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_recycler_sub_categories, container, false)

        var SubCategoriesRecyclerView = root.findViewById<RecyclerView>(R.id.recycler_sub_categories)

        var SubCategoriesList = ArrayList<SubCategories>()

        SubCategoriesList.add(SubCategories(R.drawable.ic_iconfinder_beach, "Beach", 14))
        SubCategoriesList.add(SubCategories(R.drawable.ic_ic_phone, "Phone", 4))
        SubCategoriesList.add(SubCategories(R.drawable.ic_cosmetic, "Cosmetics", 15))
        SubCategoriesList.add(SubCategories(R.drawable.ic_furniture, "Furnitures", 16))
        SubCategoriesList.add(SubCategories(R.drawable.icon_social, "Store & Convenience ", 17))

        var subCategoriesAdapter = SubCategoriesAdapter(SubCategoriesList)

        SubCategoriesRecyclerView.layoutManager = LinearLayoutManager(context)

        SubCategoriesRecyclerView.adapter = subCategoriesAdapter

        subCategoriesAdapter.setOnClickListener(this)

        return root
    }

    override fun onClick(subCategories: SubCategories) {

    }
}
