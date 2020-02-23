package com.hnineiphyu.daweidirectory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnineiphyu.daweidirectory.model.SubCategory


class SelectedSubCategoryViewModel : ViewModel(){

    private var selectedSubCategory: MutableLiveData<SubCategory> = MutableLiveData()

    fun getSelectedSubCategory(): LiveData<SubCategory> = selectedSubCategory

    fun selectedSubCategory(subCategory: SubCategory){
        selectedSubCategory.value = subCategory
    }
}
