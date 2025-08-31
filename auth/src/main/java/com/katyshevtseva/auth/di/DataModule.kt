package com.katyshevtseva.auth.di

import com.katyshevtseva.auth.data.CredentialsRepositoryImpl
import com.katyshevtseva.auth.domain.repo.CredentialsRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    @AuthScope
    fun bindCredentialsRepository(impl: CredentialsRepositoryImpl): CredentialsRepository
}