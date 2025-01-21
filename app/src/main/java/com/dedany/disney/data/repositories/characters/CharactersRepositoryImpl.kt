package com.dedany.disney.data.repositories.characters

import com.dedany.disney.domain.entities.Character
import com.dedany.disney.data.dataSources.characters.remote.CharactersRemoteDataSource

import com.dedany.disney.domain.repositories.CharactersRepository

//El que maneja el dato y lo transforma de dto a entidad y viceversa
class CharactersRepositoryImpl(
    private val remoteDataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return remoteDataSource.getCharacters().map { characterDto ->
            Character(
                id = characterDto.id,
                name = characterDto.name,
                multimedia = characterDto.films.plus(characterDto.shortFilms),
                videoGames = characterDto.videoGames,
                sourceUrl = characterDto.sourceUrl,
                image = characterDto.imageUrl
            )
        }
    }
}