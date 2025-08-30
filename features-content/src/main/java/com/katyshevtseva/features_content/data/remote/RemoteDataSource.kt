package com.katyshevtseva.features_content.data.remote

import com.katyshevtseva.features_content.data.remote.model.CourseDto
import jakarta.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllCourses(): List<CourseDto> {
        return apiService.getCourses().body()?.courses ?: throw RuntimeException()
    }
}