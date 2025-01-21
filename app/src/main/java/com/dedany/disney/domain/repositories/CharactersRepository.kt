package com.dedany.disney.domain.repositories

import com.dedany.disney.domain.entities.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}