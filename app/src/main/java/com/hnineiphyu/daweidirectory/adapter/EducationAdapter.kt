package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.education.EducationFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_education.view.*

class EducationAdapter(var educationList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return EducationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return educationList.size
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bindEducation(educationList.get(position))
    }


    var nClickListenter: ClickListenter? = null

    fun msetOnClickListener(clickListenter: EducationFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.educationList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindEducation(infosItem: InfosItem){
            this.infosItem = infosItem
            Picasso.get()
                .load(infosItem.photo)
                .placeholder(R.drawable.loading)
                .into(view.education_image)
            view.education_name.text = infosItem.cname
        }

        override fun onClick(v: View?) {
            nClickListenter?.OnClick(infosItem)
        }
    }

    interface ClickListenter {
        fun OnClick(infosItem: InfosItem)
    }
}
