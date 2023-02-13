package com.dldmswo1209.movieapp.repository

import com.dldmswo1209.movieapp.api.ApiService
import javax.inject.Inject

// @Inject 를 통해 의존성 주입 -> apiService
class TvShowRepository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}