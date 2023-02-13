package com.dldmswo1209.movieapp.api

import com.dldmswo1209.movieapp.helper.Constants
import com.dldmswo1209.movieapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}