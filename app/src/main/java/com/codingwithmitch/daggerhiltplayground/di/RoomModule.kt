package com.codingwithmitch.daggerhiltplayground.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingwithmitch.daggerhiltplayground.database.PostDao
import com.codingwithmitch.daggerhiltplayground.database.PostDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PostDataBase {
        return Room.databaseBuilder(context, PostDataBase::class.java, PostDataBase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePostDao(postDataBase: PostDataBase): PostDao {
        return postDataBase.getDao()
    }
}