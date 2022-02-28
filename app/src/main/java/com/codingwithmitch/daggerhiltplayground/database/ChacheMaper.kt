package com.codingwithmitch.daggerhiltplayground.database

import androidx.lifecycle.Transformations.map
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.networking.BlogNetworkEntityItem
import com.codingwithmitch.daggerhiltplayground.util.EntityMapper
import retrofit2.http.POST
import javax.inject.Inject

class ChacheMaper
@Inject constructor() : EntityMapper<EntityCache, Posts> {
    override fun mapTOEntity(domainModel: Posts): EntityCache {
        return EntityCache(
            id = domainModel.id,
            name = domainModel.name,
            email = domainModel.email,
            postis = domainModel.posId,
            comment = domainModel.comment
        )
    }

    override fun mapFromEntity(entity: EntityCache): Posts {
        return Posts(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            comment = entity.comment,
            posId = entity.postis
        )
    }

    fun mapFromEntityList(entity: List<EntityCache>): List<Posts> {
        return entity.map {
            mapFromEntity(it)
        }
    }
}