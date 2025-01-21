package com.dedany.disney.data.dataSources.characters.remote

import com.dedany.disney.data.dataSources.characters.remote.dto.CharacterDto

interface CharactersRemoteDataSource {
    suspend fun getCharacters(): List<CharacterDto>
}