package com.hnineiphyu.daweidirectory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnineiphyu.daweidirectory.model.SubCategories


class SelectedSubCategoriesViewModel : ViewModel(){

    private var selectedSubCategories: MutableLiveData<SubCategories> = MutableLiveData()

    fun getSelectedSubCategory(): LiveData<SubCategories> = selectedSubCategories

    fun selectedSubCategories(subCategories: SubCategories){
        selectedSubCategories.value = subCategories
    }
}
