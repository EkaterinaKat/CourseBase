package com.katyshevtseva.features_content.data.remote

import com.katyshevtseva.features_content.di.FeatureContentScope
import jakarta.inject.Inject
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@FeatureContentScope
class ApiFactory @Inject constructor() {

    private val okHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    companion object {
        private const val BASE_URL = "https://drive.usercontent.google.com/"
    }
}