package com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmoralf.retrofit2cleanarchitectureapp.core.utils.Utils.Companion.printError
import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.Response.*
import com.rmoralf.retrofit2cleanarchitectureapp.presentation.components.ProgressBar
import com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery.components.GalleryEmptyList
import com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery.components.GalleryGrid
import com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery.components.GalleryTopBar

@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            GalleryTopBar()
        }
    ) {
        when (val imagesResponse = viewModel.state.value) {
            is Loading -> ProgressBar()
            is Success -> {
                val imageList = imagesResponse.data
                if (imageList.isNullOrEmpty()) {
                    GalleryEmptyList()
                } else {
                    GalleryGrid(imageList = imageList)
                }
            }
            is Error -> printError(imagesResponse.message)
        }

    }
}