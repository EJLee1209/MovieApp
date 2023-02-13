package com.dldmswo1209.movieapp.di

import com.dldmswo1209.movieapp.api.ApiService
import com.dldmswo1209.movieapp.helper.Constants
import com.dldmswo1209.movieapp.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Hilt는 외부 라이브러리(Retrofit 등)의 객체 생성 방법을 알지 못한다.
// 따라서 @Module 을 사용해 알려 줘야 한다.
// InstallIn(SingletonComponent::class) 는 해당 모듈을 싱글턴으로 사용하겠다는 의미

// 해당 모듈 오브젝트 안에서 의존성 주입을 하기 위한 함수를 구현하는데, 여기서 @Provides, @Singleton 어노테이션을 사용한다.
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String) : ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}