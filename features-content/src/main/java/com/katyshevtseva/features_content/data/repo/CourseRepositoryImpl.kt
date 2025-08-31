package com.katyshevtseva.features_content.data.repo

import com.katyshevtseva.features_content.data.local.LocalDataSource
import com.katyshevtseva.features_content.data.mapper.CourseMapper
import com.katyshevtseva.features_content.data.remote.RemoteDataSource
import com.katyshevtseva.features_content.data.util.DateParser
import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.domain.model.SortMethod
import com.katyshevtseva.features_content.domain.repo.CourseRepository
import jakarta.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val courseMapper: CourseMapper
) : CourseRepository {

    override suspend fun getAllCourses(sortMethod: SortMethod?): List<Course> {
        var courses = remoteDataSource.getAllCourses().map {
            courseMapper.mapDtoToDomainModel(it, localDataSource.existsById(it.id))
        }

        if (sortMethod != null) {
            courses = sort(courses, sortMethod)
        }

        return courses
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

    private fun sort(list: List<Course>, sortMethod: SortMethod): List<Course> {
        return when (sortMethod) {
            SortMethod.PUBLISH_DATE_ASC -> {
                list.sortedBy { DateParser.parse(it.publishDate) }
            }

            SortMethod.PUBLISH_DATE_DESC -> {
                list.sortedByDescending { DateParser.parse(it.publishDate) }
            }
        }
    }
}