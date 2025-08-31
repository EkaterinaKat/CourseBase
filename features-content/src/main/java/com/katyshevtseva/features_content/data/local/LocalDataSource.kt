package com.katyshevtseva.features_content.data.local

import com.katyshevtseva.features_content.data.local.entity.CourseEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val courseDao: CourseDao
) {

    suspend fun add(course: CourseEntity) {
        courseDao.add(course)
    }

    suspend fun deleteById(id: Int) {
        courseDao.deleteById(id)
    }

    suspend fun getCourses(): List<CourseEntity> {
        return courseDao.getCourses()
    }

    suspend fun existsById(id: Int): Boolean {
        return courseDao.existsById(id)
    }
}