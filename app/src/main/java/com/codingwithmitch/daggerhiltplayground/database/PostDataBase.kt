package com.codingwithmitch.daggerhiltplayground.database

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [EntityCache::class],version = 1)
abstract class PostDataBase: RoomDatabase() {
    abstract fun getDao():PostDao
    companion object{
        val DATABASE_NAME:String="posts_db"

    }
}