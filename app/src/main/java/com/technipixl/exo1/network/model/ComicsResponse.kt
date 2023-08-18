package com.technipixl.exo1.network.model

data class ComicsResponse(
    val data: DataComicsResponse
)

data class DataComicsResponse (
    val results: List<MarvelComics>
)

data class MarvelComics(
    val id: String,
    val name: String,
    // add thumbnail
    var thumbnail: ThumbnailComics
)

data class ThumbnailComics (
    val path: String,
    val extension: String
)