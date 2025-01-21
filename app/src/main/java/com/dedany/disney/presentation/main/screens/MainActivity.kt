package com.dedany.disney.presentation.main.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.dedany.disney.data.dataSources.characters.remote.CharactersRemoteDataSource
import com.dedany.disney.data.dataSources.characters.remote.CharactersRemoteDataSourceImpl
import com.dedany.disney.data.repositories.characters.CharactersRepositoryImpl
import com.dedany.disney.databinding.ActivityMainBinding
import com.dedany.disney.domain.entities.Character
import com.dedany.disney.domain.repositories.characters.CharactersRepository
import com.dedany.disney.domain.useCases.characters.CharactersUseCase
import com.dedany.disney.domain.useCases.characters.CharactersUseCaseImpl
import com.dedany.disney.presentation.main.screens.adapter.CharactersListAdapter

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var viewModel: MainViewModel? = null

    private var characterAdapter: CharactersListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val dataSource: CharactersRemoteDataSource = CharactersRemoteDataSourceImpl()

        val repository: CharactersRepository = CharactersRepositoryImpl(
            remoteDataSource = dataSource
        )

        val useCase: CharactersUseCase = CharactersUseCaseImpl(
            repository = repository
        )

        viewModel = MainViewModel(
            useCase = useCase
        )

        setAdapters()
    }

    private fun setAdapters() {
        characterAdapter = CharactersListAdapter()
        binding?.recyclerCharacters?.adapter = characterAdapter
    }
}
