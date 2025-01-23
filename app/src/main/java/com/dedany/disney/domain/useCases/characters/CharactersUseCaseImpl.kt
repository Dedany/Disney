package com.dedany.disney.domain.useCases.characters

import com.dedany.disney.domain.entities.Character
import com.dedany.disney.domain.repositories.characters.CharactersRepository

class CharactersUseCaseImpl(
    private val repository: CharactersRepository
): CharactersUseCase {

    override suspend fun getCharacters(): List<Character> {
        val characters = repository.getCharacters()
        // Puede que haga lógica, pero no es el caso.
        return characters
    }
}