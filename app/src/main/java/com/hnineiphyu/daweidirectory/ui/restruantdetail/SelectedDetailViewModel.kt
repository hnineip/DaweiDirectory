package com.hnineiphyu.daweidirectory.ui.restruantdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos


class SelectedDetailViewModel : ViewModel(){

    private var selectedDetail: MutableLiveData<InfosItem> = MutableLiveData()

    fun getSelectedDetail(): LiveData<InfosItem> = selectedDetail

    fun selectedDetail(infosItem: InfosItem){
        selectedDetail.value = infosItem
    }
}
