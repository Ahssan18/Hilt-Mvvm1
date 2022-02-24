package com.codingwithmitch.daggerhiltplayground.repository

import androidx.lifecycle.MutableLiveData
import com.codingwithmitch.daggerhiltplayground.database.ChacheMaper
import com.codingwithmitch.daggerhiltplayground.database.PostDao
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.networking.NetworkMapper
import com.codingwithmitch.daggerhiltplayground.networking.PostServices
import com.codingwithmitch.daggerhiltplayground.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor
    (
    private val postServices: PostServices,
    private val postDao: PostDao,
    private val networkMapper: NetworkMapper,
    private val chacheMaper: ChacheMaper
) {

    suspend fun getComments() :Flow<DataState<List<Posts>>> = flow {
        emit(DataState.Loading)
        try {
            val postList = postServices.gerPosts()
            val data = networkMapper.mapFromNetworkListToPosts(postList)
            for (post in data) {
                postDao.addPost(chacheMaper.mapTOEntity(post))
            }
            var postEntity = postDao.getAllComments()
            emit(DataState.OnSuccess(chacheMaper.mapFromEntityList(postEntity)))
        } catch (e: Exception) {
            emit(DataState.onFailure(e))
        }
    }
}