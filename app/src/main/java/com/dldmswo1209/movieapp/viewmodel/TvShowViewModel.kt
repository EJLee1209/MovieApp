package com.dldmswo1209.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dldmswo1209.movieapp.model.TvShowItem
import com.dldmswo1209.movieapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel 에서는 @HiltViewModel 사용
// @Inject 를 통해 의존성 주입 이때, constructor 와 반드시 함께 사용 해야 한다.

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: TvShowRepository) : ViewModel(){

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>> = _response

    init{
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let {response->
            if(response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("testt", "getAllTvShows Error: ${response.code()}")
            }
        }
    }

}