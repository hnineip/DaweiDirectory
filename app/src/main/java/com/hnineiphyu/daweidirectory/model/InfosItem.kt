package com.hnineiphyu.daweidirectory.model

import com.google.gson.annotations.SerializedName

data class InfosItem(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("listing_id")
	val listingId: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("cname")
	val cname: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("phoneno")
	val phoneno: String? = null
)