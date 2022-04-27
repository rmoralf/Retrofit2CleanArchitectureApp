package com.rmoralf.retrofit2cleanarchitectureapp.data.repository

import com.rmoralf.retrofit2cleanarchitectureapp.data.network.remote.ImagesService
import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.Response.*
import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.toDomain
import com.rmoralf.retrofit2cleanarchitectureapp.domain.repository.ImageRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class ImageRepositoryImpl @Inject constructor(
    private val service: ImagesService
) : ImageRepository {
    override suspend fun getImages() = flow {
        try {
            emit(Loading)
            val imageList = service
                .getImages()
                .map { it.toDomain() }
            emit(Success(imageList))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }
}