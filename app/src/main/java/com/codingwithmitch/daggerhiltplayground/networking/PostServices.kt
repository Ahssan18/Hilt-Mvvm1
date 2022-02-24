package com.codingwithmitch.daggerhiltplayground.networking

import retrofit2.http.GET

interface PostServices {
    @GET("comments")
    suspend fun gerPosts(): BlogNetworkEntity
}