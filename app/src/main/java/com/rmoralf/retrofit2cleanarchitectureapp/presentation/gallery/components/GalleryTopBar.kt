package com.rmoralf.retrofit2cleanarchitectureapp.presentation.gallery.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rmoralf.retrofit2cleanarchitectureapp.R

@Composable
fun GalleryTopBar(){
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}