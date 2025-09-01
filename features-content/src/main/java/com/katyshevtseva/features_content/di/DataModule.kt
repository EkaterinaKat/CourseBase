package com.katyshevtseva.features_content.di

import android.app.Application
import com.katyshevtseva.features_content.data.local.CourseDao
import com.katyshevtseva.features_content.data.local.CourseDatabase
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
    @FeatureContentScope
    fun bindCourseRepository(impl: CourseRepositoryImpl): CourseRepository

    companion object {

        @Provides
        @FeatureContentScope
        fun provideApiService(apiFactory: ApiFactory): ApiService {
            return apiFactory.apiService
        }

        @Provides
        @FeatureContentScope
        fun provideCourseDao(application: Application): CourseDao {
            return CourseDatabase.getInstance(application).courseDao()
        }
    }
}