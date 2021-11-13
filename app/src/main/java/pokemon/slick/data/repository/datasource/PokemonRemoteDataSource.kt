package pokemon.slick.data.repository.datasource

import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonList
import retrofit2.Response

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Response<PokemonList>
    suspend fun getPokemon(id: String): Response<Pokemon?>
}