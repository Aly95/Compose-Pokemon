package pokemon.slick.data.repository

import pokemon.slick.data.api.PokemonService
import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonList
import pokemon.slick.data.repository.datasource.PokemonRemoteDataSource
import retrofit2.Response

class PokemonRemoteDataSourceImpl(
    private val apiKey: String,
    private val pokemonService: PokemonService
): PokemonRemoteDataSource {
    override suspend fun getPokemonList(): Response<PokemonList> = pokemonService.getAllPokemon()
    override suspend fun getPokemon(id: String) = pokemonService.getPokemon(id)
}