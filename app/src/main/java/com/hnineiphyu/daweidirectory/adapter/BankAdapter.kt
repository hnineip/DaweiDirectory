package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.bank.BankFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bank.view.*

class BankAdapter(var bankList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<BankAdapter.BankViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        return BankViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bankList.size
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bindBank(bankList.get(position))
    }

    var nClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: BankFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.bankList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindBank(infosItem: InfosItem){
            this.infosItem = infosItem
            Picasso.get()
                .load(infosItem.photo)
                .into(view.bank_image)
            view.bank_name.text = infosItem.title
        }

        override fun onClick(v: View?) {
            nClickListenter?.OnClick(infosItem)
        }
    }
    interface ClickListenter {
        fun OnClick(infosItem: InfosItem)
    }
}
