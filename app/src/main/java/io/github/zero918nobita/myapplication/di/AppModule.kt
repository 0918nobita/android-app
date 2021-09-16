package io.github.zero918nobita.myapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.zero918nobita.myapplication.repository.MainRepository
import io.github.zero918nobita.myapplication.repository.MainRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun bindMainRepository(impl: MainRepositoryImpl): MainRepository
}
