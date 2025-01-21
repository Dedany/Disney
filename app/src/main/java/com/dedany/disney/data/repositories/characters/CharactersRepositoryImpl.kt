package com.dedany.disney.data.repositories.characters

import com.dedany.disney.domain.entities.Character
import com.dedany.disney.data.dataSources.characters.remote.CharactersRemoteDataSource
import com.dedany.disney.data.dataSources.characters.remote.dto.CharacterDto

import com.dedany.disney.domain.repositories.characters.CharactersRepository

//El que maneja el dato y lo transforma de dto a entidad y viceversa
class CharactersRepositoryImpl(
    private val remoteDataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        val characterNames: List<String> = remoteDataSource.getCharacters().map { characterDto ->
            characterDto.name
        }

        // Old way
        val charactersDto = remoteDataSource.getCharacters()
        val charactersMapped = mutableListOf<Character>()
        charactersDto.forEach { characterDto: CharacterDto ->
            charactersMapped.add(
                Character(
                    id = characterDto.id,
                    name = characterDto.name,
                    multimedia = characterDto.films.plus(characterDto.shortFilms),
                    videoGames = characterDto.videoGames,
                    sourceUrl = characterDto.sourceUrl,
                    image = characterDto.imageUrl
                )
            )
        }

        // Cool way / Manera guay
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