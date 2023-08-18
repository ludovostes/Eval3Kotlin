package com.technipixl.exo1.network.model

// 4.
data class MarvelResponse(
    val data: DataResponse
)

data class DataResponse (
    val results: List<MarvelChar>
)

data class MarvelChar(
    val id: String,
    val name: String,
    // add thumbnail
    var thumbnail: Thumbnail
)

data class Thumbnail(
    val path: String,
    val extension: String
)
