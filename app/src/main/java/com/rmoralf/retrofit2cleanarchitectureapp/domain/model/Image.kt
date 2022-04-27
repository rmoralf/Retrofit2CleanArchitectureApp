package com.rmoralf.retrofit2cleanarchitectureapp.domain.model

import com.rmoralf.retrofit2cleanarchitectureapp.data.network.entities.ApiImage

data class Image(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)

fun ApiImage.toDomain() = Image(
    id = id,
    author = author,
    width = width,
    height = height,
    url = url,
    download_url = download_url
)
