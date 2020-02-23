package com.hnineiphyu.daweidirectory.ui.emergency


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnineiphyu.daweidirectory.api.DirectoryApi
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmergencyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {

    }
    val text: LiveData<String> = _text

    var results: MutableLiveData<ResponseInfos> = MutableLiveData()
    var networkError: MutableLiveData<Boolean> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getResult(): LiveData<ResponseInfos> = results

    fun getErrors(): LiveData<Boolean> = networkError

    fun getLoading(): LiveData<Boolean> = loading

    private val directoryApi: DirectoryApi = DirectoryApi()

    fun loadResults() {

        loading.value = true

        var Call = directoryApi.getResult(13)

        Call.enqueue(object: Callback<ResponseInfos> {
            override fun onResponse(call: Call<ResponseInfos>, response: Response<ResponseInfos>) {
                response.isSuccessful.let {
                    loading.value = false
                    val resultList = ResponseInfos(
                        response.body()?.infos?: emptyList())
                    results.value = resultList
                }
            }

            override fun onFailure(call: Call<ResponseInfos>, t: Throwable) {
                loading.value = false
                networkError.value = true
            }
        })
    }
}