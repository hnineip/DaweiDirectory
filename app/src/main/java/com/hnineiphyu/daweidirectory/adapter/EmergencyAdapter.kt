package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.emergency.EmergencyFragment
import kotlinx.android.synthetic.main.item_emergency.view.*


class EmergencyAdapter(var emergencyList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_emergency, parent, false)
        return EmergencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emergencyList.size
    }

    override fun onBindViewHolder(holder: EmergencyViewHolder, position: Int) {
        holder.bindEmergency(emergencyList.get(position))
    }


    var nClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: EmergencyFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.emergencyList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class EmergencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindEmergency(infosItem: InfosItem){
            this.infosItem = infosItem
            view.name.text = infosItem.title
            view.address.text = infosItem.address
            view.phone_number.text = infosItem.phoneno
        }

        override fun onClick(v: View?) {
            nClickListenter?.OnClick(infosItem)
        }
    }
    interface ClickListenter {
        fun OnClick(infosItem: InfosItem)
    }
}

