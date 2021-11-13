package pokemon.slick.data.api

import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonBase
import pokemon.slick.data.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon?&limit=10")
    suspend fun getAllPokemon(): Response<PokemonList>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: String): Response<Pokemon?>
}