package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.MainCategory
import kotlinx.android.synthetic.main.item_list.view.*

class MainCategoryAdapter(var categoryList: ArrayList<MainCategory> = ArrayList()) :
    RecyclerView.Adapter<MainCategoryAdapter.MainCategoryViewHolder>() {

    var mClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: ClickListenter) {
        this.mClickListenter = clickListenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainCategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MainCategoryViewHolder, position: Int) {
//        holder.Image.setImageResource(categoryList[position].icon)
//        holder.Name.text = categoryList[position].name
        holder.bind(categoryList.get(position))
    }

    inner class MainCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private lateinit var mainCategory: MainCategory

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(mainCategory: MainCategory){

            this.mainCategory = mainCategory
            itemView.category_name.text = mainCategory.name
            itemView.icon_restruant.setImageResource(mainCategory.icon)

        }

//        var Name = itemView.findViewById<TextView>(R.id.category_name)
//        var Image = itemView.findViewById<ImageView>(R.id.icon_restruant)

        override fun onClick(v: View?) {
            mClickListenter?.onClick(mainCategory)
        }
    }

    interface ClickListenter {
        fun onClick(mainCategory: MainCategory)
    }
}