package com.dedany.disney.presentation.main.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedany.disney.domain.entities.Character
import com.dedany.disney.domain.useCases.characters.CharactersUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: CharactersUseCase
): ViewModel() {

    private val _characters: MutableLiveData<Character> = MutableLiveData<Character>()
    val characters: LiveData<Character> = _characters

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                val characters: List<Character> = useCase.getCharacters()
            } catch (e: Exception) {
                Log.e("ERROR", e.stackTraceToString())
            }
        }
    }
}