package com.rmoralf.retrofit2cleanarchitectureapp.di

import com.rmoralf.retrofit2cleanarchitectureapp.core.utils.Constants.API_ENDPOINT
import com.rmoralf.retrofit2cleanarchitectureapp.data.network.remote.ImagesService
import com.rmoralf.retrofit2cleanarchitectureapp.data.repository.ImageRepositoryImpl
import com.rmoralf.retrofit2cleanarchitectureapp.domain.repository.ImageRepository
import com.rmoralf.retrofit2cleanarchitectureapp.domain.usecases.GetImages
import com.rmoralf.retrofit2cleanarchitectureapp.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesImageRepository(
        imagesService: ImagesService
    ): ImageRepository = ImageRepositoryImpl(imagesService)

    @Provides
    fun provideImagesService(restClient: Retrofit): ImagesService =
        restClient.create()

    @Provides
    fun providesUseCases(
        imageRepository: ImageRepository
    ) = UseCases(
        getImages = GetImages(imageRepository)
    )

    //Retrofit2
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
}