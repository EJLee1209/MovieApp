package com.dldmswo1209.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.dldmswo1209.movieapp.databinding.TvShowLayoutBinding
import com.dldmswo1209.movieapp.model.TvShowItem

class TvShowAdapter: ListAdapter<TvShowItem,TvShowAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(private val binding: TvShowLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(tvShow: TvShowItem){
            binding.textView.text = tvShow.name
            binding.imageView.load(tvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffCallback = object: DiffUtil.ItemCallback<TvShowItem>(){
            override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}