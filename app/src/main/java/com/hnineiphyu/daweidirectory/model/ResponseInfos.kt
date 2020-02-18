package com.hnineiphyu.daweidirectory.model

import com.google.gson.annotations.SerializedName

data class ResponseInfos(

	@field:SerializedName("infos")
	val infos: List<InfosItem?>? = null
)