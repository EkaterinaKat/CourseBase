package com.katyshevtseva.features_content.presentation.util

import com.katyshevtseva.features_content.domain.model.Course
import com.katyshevtseva.features_content.presentation.adapter.CourseItem

fun mapDomainModelToListItem(course: Course) = CourseItem(
    id = course.id,
    title = course.title,
    favourite = course.favourite,
    text = course.text,
    price = course.price,
    rate = course.rate,
    startDate = course.startDate,
    publishDate = course.publishDate
)

fun mapListItemToDomainModel(course: CourseItem) = Course(
    id = course.id,
    title = course.title,
    favourite = course.favourite,
    text = course.text,
    price = course.price,
    rate = course.rate,
    startDate = course.startDate,
    publishDate = course.publishDate
)