package com.dedany.disney.domain.useCases.characters

import com.dedany.disney.domain.entities.Character
import com.dedany.disney.domain.repositories.characters.CharactersRepository

class CharactersUseCaseImpl(
    private val repository: CharactersRepository
): CharactersUseCase {

    override suspend fun getCharacters(): List<Character> {
        return repository.getCharacters()
    }
}