package com.katyshevtseva.features_content.data.repo

import com.katyshevtseva.features_content.data.mapper.CourseMapper
import com.katyshevtseva.features_content.data.remote.RemoteDataSource
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import jakarta.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val courseMapper: CourseMapper
) : CourseRepository {

    override suspend fun getAllCourses(): List<Course> {
        return remoteDataSource.getAllCourses().map {
            courseMapper.mapDtoToDomainModel(it)
        }
    }
}