package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.hotel.HotelFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_education.view.*

class HotelAdapter(var hotelList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
        return HotelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bindHotel(hotelList.get(position))
    }


    var nClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: HotelFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.hotelList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindHotel(infosItem: InfosItem){
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
