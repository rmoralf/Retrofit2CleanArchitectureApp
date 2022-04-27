package com.rmoralf.retrofit2cleanarchitectureapp.domain.repository

import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.Image
import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getImages(): Flow<Response<List<Image>>>
}