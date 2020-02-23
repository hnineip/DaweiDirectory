package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.SubCategory
import com.hnineiphyu.daweidirectory.ui.subcategory.SubCategoryFragment
import kotlinx.android.synthetic.main.item_sub_category.view.*

class SubCategoryAdapter(var subcategoryList: ArrayList<SubCategory> = ArrayList()) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    var mClickListener: ClickListenter? = null

    fun setOnClickListener(clickListenter: ClickListenter) {
        this.mClickListener = clickListenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_sub_category, parent, false)
        return SubCategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
       return subcategoryList.size
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.bind(subcategoryList.get(position))
    }


    inner class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private lateinit var subCategory: SubCategory

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(subCategory: SubCategory){
            this.subCategory = subCategory
            itemView.sub_category_name.text = subCategory.name
            itemView.icon_sub_category.setImageResource(subCategory.icon)

        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(subCategory)
        }
    }

    interface ClickListenter {
        fun onClick(subCategory: SubCategory)
    }

}