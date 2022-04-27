package com.rmoralf.retrofit2cleanarchitectureapp.data.network.remote

import com.rmoralf.retrofit2cleanarchitectureapp.data.network.entities.ApiImage
import retrofit2.http.GET

interface ImagesService {
    @GET("/v2/list")
    suspend fun getImages(
    ): List<ApiImage>
}