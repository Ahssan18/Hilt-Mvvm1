package com.codingwithmitch.daggerhiltplayground.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "postsComments")
data class EntityCache(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "postId")
    var postis: Int,

    @ColumnInfo(name = "postComment")
    var comment: String
)