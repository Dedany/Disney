package com.dedany.disney.domain.useCases.characters

import com.dedany.disney.domain.entities.Character

interface CharactersUseCase {
    suspend fun getCharacters(): List<Character>
}