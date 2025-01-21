package com.dedany.disney.data.dataSources.characters.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("_id")
    val id: Int,
    val name: String,
    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val sourceUrl: String,
    val imageUrl: String
)
