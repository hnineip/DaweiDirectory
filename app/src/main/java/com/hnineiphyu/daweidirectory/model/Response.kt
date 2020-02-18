package com.hnineiphyu.daweidirectory.model

data class InfosResult(val infos: List<Infos>)

data class Infos(
    val id: String,
    val title: String,
    val photo: String,
    val location: String,
    val address: String,
    val phoneno: String,
    val description: String
)
