package com.dedany.disney.data.dataSources.characters.remote.api

import com.dedany.disney.data.dataSources.characters.remote.dto.CharacterDataDto
import retrofit2.Response
import retrofit2.http.GET

interface DisneyApi {
    @GET("/characters")
    suspend fun getCharacters():Response<CharacterDataDto> //llamada para mostrar una vista
}