package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.restruant.RestruantFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestruantAdapter(var restruantList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<RestruantAdapter.RestrauantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestrauantViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestrauantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restruantList.size
    }

    override fun onBindViewHolder(holder: RestrauantViewHolder, position: Int) {
        holder.bindRestruant(restruantList.get(position))
    }

    var mClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: RestruantFragment) {
        this.mClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.restruantList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class RestrauantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindRestruant(infosItem: InfosItem){
            this.infosItem = infosItem
            Picasso.get()
                .load(infosItem.photo)
                .placeholder(R.drawable.loading)
                .into(view.restruant_image)
            view.restruant_name.text = infosItem.title
        }

        override fun onClick(v: View?) {
            mClickListenter?.onClick(infosItem)
        }
    }

    interface ClickListenter {
        fun onClick(infosItem: InfosItem)
    }
}
