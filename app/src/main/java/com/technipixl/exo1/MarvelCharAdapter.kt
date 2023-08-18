package com.technipixl.exo1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.FragmentCharactersBinding
import com.technipixl.exo1.network.model.DataResponse
import com.technipixl.exo1.network.model.MarvelChar

// 10.1
class MarvelCharAdapter(private var data: List<MarvelChar>, private val onItemClick: (MarvelChar) -> Unit) : RecyclerView.Adapter<MarvelCharViewHolder>() {
    lateinit var binding: FragmentCharactersBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelCharViewHolder {
        binding = FragmentCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelCharViewHolder(
            FragmentCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MarvelCharViewHolder, position: Int) {
        holder.blind(data[position])
    }
}