package com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rmoralf.retrofit2cleanarchitectureapp.domain.model.Image

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GalleryGrid(
    imageList: List<Image>
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(imageList) { image ->
            GalleryGridItem(image)
        }
    }
}