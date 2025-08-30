package com.katyshevtseva.features_content.data.remote

import com.katyshevtseva.features_content.data.remote.model.CourseListDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): Response<CourseListDto>
}