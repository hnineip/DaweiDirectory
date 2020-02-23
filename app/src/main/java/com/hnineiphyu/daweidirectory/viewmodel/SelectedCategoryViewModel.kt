package com.hnineiphyu.daweidirectory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnineiphyu.daweidirectory.model.MainCategory


class SelectedCategoryViewModel : ViewModel(){

    private var selectedCategory: MutableLiveData<MainCategory> = MutableLiveData()

    fun getSelectedCategory(): LiveData<MainCategory> = selectedCategory

    fun selectedCategory(mainCategory: MainCategory){
        selectedCategory.value = mainCategory
    }
}
