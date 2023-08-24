package com.example.myapplication.di

import com.example.myapplication.data.repository.TestRepository
import com.example.myapplication.data.repository.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsTestRepository(
        repositoryImpl: TestRepositoryImpl
    ): TestRepository
}