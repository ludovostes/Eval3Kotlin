package com.technipixl.exo1

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technipixl.exo1.databinding.FragmentCharactersBinding
import com.technipixl.exo1.network.model.MarvelChar

// 9.
class MarvelCharViewHolder (private var viewBinding: FragmentCharactersBinding,
                            private val onItemClick: (MarvelChar) -> Unit
) :

    RecyclerView.ViewHolder(viewBinding.root) {

    // 10.2 se crée via le blind du fichier Crypto Adapter
    fun blind(marvelChar: MarvelChar) {
        viewBinding.charNameTextView.text = marvelChar.name

        setupImage("${marvelChar.thumbnail.path}.${marvelChar.thumbnail.extension}")

        viewBinding.container.setOnClickListener {
            onItemClick(marvelChar)
        }

    }

    // 13
    private fun setupImage(url: String) {
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(viewBinding.charImageView)
    }

}