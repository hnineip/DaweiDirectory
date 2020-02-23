package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.health.HealthFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_health.view.*

class HealthAdapter(var healthlList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<HealthAdapter.HealthViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_health, parent, false)
        return HealthViewHolder(view)
    }

    override fun getItemCount(): Int {
        return healthlList.size
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        holder.bindHealth(healthlList.get(position))
    }

    var nClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: HealthFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.healthlList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class HealthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindHealth(infosItem: InfosItem) {
            this.infosItem = infosItem
            Picasso.get()
                .load(infosItem.photo)
                .into(view.health_image)
            view.health_name.text = infosItem.title
        }

        override fun onClick(v: View?) {
            nClickListenter?.OnClick(infosItem)
        }
    }

        interface ClickListenter {
            fun OnClick(infosItem: InfosItem)
        }
    }

