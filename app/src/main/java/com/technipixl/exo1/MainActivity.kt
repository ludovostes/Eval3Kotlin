package com.technipixl.exo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.KeyChain.EXTRA_NAME
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.exo1.databinding.ActivityMainBinding
import com.technipixl.exo1.network.MarvelImpl
import com.technipixl.exo1.network.model.MarvelChar
import com.technipixl.exo1.network.model.MarvelResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    // 6.1
    private val marvelService by lazy { MarvelImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMarvelCharData()
    }

    // 6.2
    private fun getMarvelCharData() {

        // 2. Déplacer entre le point 8 et 9 pour vérifier si l'appel réseaux fonctionne
        // A déplacer plus tard
        val timeStamp = Date().time
        val privateKey = "de497cad0966892fd6b5ad3503c55cb21ca99830"
        val publicKey = "cbe34ea6c8486ed5495a8ff90f48daa8"
        val hashExample = HashGenerator.generateHash(timeStamp, privateKey, publicKey)

        CoroutineScope(Dispatchers.IO).launch {
            val response = marvelService.getMarvelChar(ts = timeStamp, apiKey = publicKey, hash = hashExample)
            withContext(Dispatchers.Main) {
                // 12. Appeler
                response.body()?.let { body -> setupRecyclerView(marvelCharList = body.data.results)
                }
            }
        }
    }

    // 11.
    private fun setupRecyclerView(marvelCharList:List<MarvelChar>) {

        //récupération du composant RecyclerView
        val recyclerView = binding.mainRecyclerView

        //defintion de son layout
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) //LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = MarvelCharAdapter( data = marvelCharList) {
                marvelChar -> goToDetail(marvelChar)
        }
        recyclerView.adapter = adapter
    }

    private fun goToDetail(marvelChar: MarvelChar) {
        val intent = Intent(this, ComicsDetailFragment::class.java)
        intent.putExtra(EXTRA_NAME, marvelChar.name)
        startActivity(intent)
    }
}