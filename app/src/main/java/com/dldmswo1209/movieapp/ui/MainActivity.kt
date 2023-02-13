package com.dldmswo1209.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dldmswo1209.movieapp.adapter.TvShowAdapter
import com.dldmswo1209.movieapp.databinding.ActivityMainBinding
import com.dldmswo1209.movieapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

// ViewModel 을 사용 하는 Activity 에서 @AndroidEntryPoint 를 붙여야 함
// 만약 Fragment 에서 ViewModel 을 사용 한다면, Fragment 가 붙어 있는 Activity 에 붙이면 됨.
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpRv()

    }

    private fun setUpRv() {
        tvShowAdapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
        }

        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(this){listTvShows->
            tvShowAdapter.submitList(listTvShows)
        }
    }
}