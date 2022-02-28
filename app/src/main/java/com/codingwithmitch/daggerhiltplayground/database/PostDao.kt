package com.codingwithmitch.daggerhiltplayground.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingwithmitch.daggerhiltplayground.model.Posts

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPost(entityCache: EntityCache): Long

    @Query("Select * from postsComments")
    suspend fun getAllComments(): List<EntityCache>
}