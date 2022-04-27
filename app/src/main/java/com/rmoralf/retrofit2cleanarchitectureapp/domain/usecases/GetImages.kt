package com.rmoralf.retrofit2cleanarchitectureapp.domain.usecases

import com.rmoralf.retrofit2cleanarchitectureapp.domain.repository.ImageRepository

class GetImages(
    private val repository: ImageRepository
) {
    suspend operator fun invoke() = repository.getImages()
}