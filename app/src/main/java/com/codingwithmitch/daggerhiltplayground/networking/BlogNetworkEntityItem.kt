package com.codingwithmitch.daggerhiltplayground.networking

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BlogNetworkEntityItem(
    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("postId")
    @Expose
    val postId: Int
)