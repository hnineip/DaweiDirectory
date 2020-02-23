package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.SubCategories
import kotlinx.android.synthetic.main.item_subcategories.view.*

class SubCategoriesAdapter(var subcategoriesList: ArrayList<SubCategories> = ArrayList()) :
    RecyclerView.Adapter<SubCategoriesAdapter.SubCategoriesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoriesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategories, parent, false)
        return SubCategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subcategoriesList.size
    }

    override fun onBindViewHolder(holder: SubCategoriesViewHolder, position: Int) {
        holder.bind(subcategoriesList.get(position))

    }

    var mClickListener: ClickListenter? = null

    fun setOnClickListener(clickListenter: ClickListenter) {
        this.mClickListener = clickListenter
    }

    inner class SubCategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private lateinit var subCategories: SubCategories

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(subCategories: SubCategories){
            this.subCategories = subCategories
            itemView.subcategories_name.text = subCategories.name
            itemView.subcategories_image.setImageResource(subCategories.icon)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(subCategories)
        }
    }

    interface ClickListenter {
        fun onClick(subCategories: SubCategories)
    }
}