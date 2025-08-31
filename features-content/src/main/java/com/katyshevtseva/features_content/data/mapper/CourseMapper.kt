package com.katyshevtseva.features_content.data.mapper

import com.katyshevtseva.features_content.data.local.entity.CourseEntity
import com.katyshevtseva.features_content.data.remote.model.CourseDto
import com.katyshevtseva.features_content.domain.model.Course
import javax.inject.Inject

class CourseMapper @Inject constructor() {

    fun mapDtoToDomainModel(dto: CourseDto, existsInDb: Boolean) = Course(
        id = dto.id,
        title = dto.title,
        favourite = existsInDb,
        text = dto.text,
        price = dto.price,
        rate = dto.rate,
        startDate = dto.startDate,
        publishDate = dto.publishDate
    )

    fun mapDomainModelToEntity(course: Course) = CourseEntity(
        id = course.id,
        title = course.title,
        text = course.text,
        price = course.price,
        rate = course.rate,
        startDate = course.startDate,
        publishDate = course.publishDate
    )

    fun mapEntityToDomainModel(entity: CourseEntity) = Course(
        id = entity.id,
        title = entity.title,
        favourite = true,
        text = entity.text,
        price = entity.price,
        rate = entity.rate,
        startDate = entity.startDate,
        publishDate = entity.publishDate
    )
}