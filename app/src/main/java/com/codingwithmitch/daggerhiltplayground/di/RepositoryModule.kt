package com.codingwithmitch.daggerhiltplayground.di

import com.codingwithmitch.daggerhiltplayground.database.ChacheMaper
import com.codingwithmitch.daggerhiltplayground.database.PostDao
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.networking.NetworkMapper
import com.codingwithmitch.daggerhiltplayground.networking.PostServices
import com.codingwithmitch.daggerhiltplayground.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        postServices: PostServices,
        postDao: PostDao,
        chacheMaper: ChacheMaper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(postServices, postDao, networkMapper, chacheMaper)
    }
}