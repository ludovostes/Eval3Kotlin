package com.technipixl.exo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.technipixl.exo1.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {

    private var binding: FragmentCharactersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}