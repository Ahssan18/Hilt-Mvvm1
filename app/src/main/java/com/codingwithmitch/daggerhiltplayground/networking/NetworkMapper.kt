package com.codingwithmitch.daggerhiltplayground.networking

import android.util.Log
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject constructor() : EntityMapper<BlogNetworkEntityItem, Posts> {
    private val TAG = "NetworkMapper"
    override fun mapTOEntity(domainModel: Posts): BlogNetworkEntityItem {
        return BlogNetworkEntityItem(
            body = domainModel.comment,
            email = domainModel.email,
            id = domainModel.id,
            postId = domainModel.posId,
            name = domainModel.name
        )
    }

    override fun mapFromEntity(entity: BlogNetworkEntityItem): Posts {
        return Posts(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            comment = entity.body,
            posId = entity.postId
        )
    }

    fun mapFromNetworkListToPosts(entity: BlogNetworkEntity): List<Posts> {
        Log.e(TAG, "entity =>" + entity.toString())
        return entity.map { mapFromEntity(it) }
    }
}