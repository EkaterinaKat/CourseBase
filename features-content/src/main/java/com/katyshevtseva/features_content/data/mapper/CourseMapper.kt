package com.katyshevtseva.features_content.data.mapper

import com.katyshevtseva.features_content.data.remote.model.CourseDto
import com.katyshevtseva.features_content.domain.model.Course
import javax.inject.Inject

class CourseMapper @Inject constructor() {

    fun mapDtoToDomainModel(dto: CourseDto) = Course(
        id = dto.id,
        title = dto.title,
        text = dto.text,
        price = dto.price,
        rate = dto.rate,
        startDate = dto.startDate,
        publishDate = dto.publishDate
    )
}