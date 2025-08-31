package com.katyshevtseva.features_content.domain.repo

import com.katyshevtseva.features_content.domain.model.Course

interface CourseRepository {

    suspend fun getAllCourses(): List<Course>

    suspend fun markFavourite(course: Course): Boolean

    suspend fun unmarkFavourite(course: Course): Boolean

    suspend fun getFavourites(): List<Course>
}