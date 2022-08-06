package com.onix.internship.homesecurity.data

import kotlinx.serialization.Serializable
@Serializable
data class House(
    val room: String,
    val type:String,
    val subtype:String,
    val value:String)


@Serializable
data class DataWebPage(
    val version: String,
    val name:String,
    val house:List<House>   )







