package com.katyshevtseva.features_content.di

import com.katyshevtseva.features_content.data.remote.ApiFactory
import com.katyshevtseva.features_content.data.remote.ApiService
import com.katyshevtseva.features_content.data.repo.CourseRepositoryImpl
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCourseRepository(impl: CourseRepositoryImpl): CourseRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(apiFactory: ApiFactory): ApiService {
            return apiFactory.apiService
        }
    }
}