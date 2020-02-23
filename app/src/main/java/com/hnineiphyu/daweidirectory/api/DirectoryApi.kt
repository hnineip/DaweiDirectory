package com.hnineiphyu.daweidirectory.api

import com.hnineiphyu.daweidirectory.model.ResponseInfos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DirectoryApi {

    private val directoryInterface: DirectoryInterface

    companion object {
        const val BASE_URL = "http://daweiapi.khaingthinkyi.me/api/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        directoryInterface = retrofit.create(DirectoryInterface::class.java)

    }

    fun getResult(key: Int): Call<ResponseInfos> {
        return directoryInterface.getInfos(key)
    }
}