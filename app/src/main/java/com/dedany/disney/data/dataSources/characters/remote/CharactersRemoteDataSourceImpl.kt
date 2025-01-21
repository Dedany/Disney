package com.dedany.disney.data.dataSources.characters.remote

import com.dedany.disney.data.dataSources.characters.remote.api.DisneyApi
import com.dedany.disney.data.dataSources.characters.remote.dto.CharacterDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//el encargado de hacer las llamadas a la API
class CharactersRemoteDataSourceImpl: CharactersRemoteDataSource {

    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.disneyapi.dev")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val disneyApi: DisneyApi = retrofit.create(DisneyApi::class.java)

    override suspend fun getCharacters(): List<CharacterDto> {
        return disneyApi.getCharacters().body()?.data ?: emptyList()
    }

}