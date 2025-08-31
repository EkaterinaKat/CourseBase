package com.katyshevtseva.features_content.data.repo

import com.katyshevtseva.features_content.data.local.LocalDataSource
import com.katyshevtseva.features_content.data.mapper.CourseMapper
import com.katyshevtseva.features_content.data.remote.RemoteDataSource
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import jakarta.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val courseMapper: CourseMapper
) : CourseRepository {

    override suspend fun getAllCourses(): List<Course> {
        return remoteDataSource.getAllCourses().map {
            courseMapper.mapDtoToDomainModel(it, localDataSource.existsById(it.id))
        }
    }

    override suspend fun markFavourite(course: Course): Boolean {
        return try {
            localDataSource.add(courseMapper.mapDomainModelToEntity(course))
            true
        } catch (e: Exception) {
            false
        }

    }

    override suspend fun unmarkFavourite(course: Course): Boolean {
        return try {
            localDataSource.deleteById(course.id)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getFavourites(): List<Course> {
        return localDataSource.getCourses().map {
            courseMapper.mapEntityToDomainModel(it)
        }
    }
}