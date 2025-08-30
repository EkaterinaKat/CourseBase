package com.katyshevtseva.features_content.data.remote.model

import com.google.gson.annotations.SerializedName

data class CourseListDto(

    @SerializedName("courses")
    val courses: List<CourseDto>
)