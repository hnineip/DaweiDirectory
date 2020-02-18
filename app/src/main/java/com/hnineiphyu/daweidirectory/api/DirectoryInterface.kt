package com.hnineiphyu.daweidirectory.api

import com.hnineiphyu.daweidirectory.model.ResponseInfos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DirectoryInterface {

    @GET("getList")
    fun getInfos(
        @Query("listing_id")
        listing_id: String
    ): Call<ResponseInfos>

}