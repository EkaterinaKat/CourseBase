package com.katyshevtseva.features_content.data.remote

import com.katyshevtseva.features_content.data.remote.model.CourseDto
import jakarta.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    private var cache: List<CourseDto>? = null

    suspend fun getAllCourses(): List<CourseDto> {
        val result: List<CourseDto> =
            cache ?: apiService.getCourses().body()?.courses ?: throw RuntimeException()

        if (cache == null) {
            cache = result
        }
        return result
    }
}