package pokemon.slick.data.repository.datasource

import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonBase
import pokemon.slick.data.repository.PokemonRepository
import timber.log.Timber

class PokemonRepositoryImpl(
    val dataSource: PokemonRemoteDataSource
): PokemonRepository {
    override suspend fun getPokemonList(): List<PokemonBase> {
        var pokemonList: List<PokemonBase> = listOf()
        try {
            val response = dataSource.getPokemonList()
            val body = response.body()
            if (body != null) {
                pokemonList = body.pokemonList
            }
        } catch (exception: Exception) {
            Timber.d("PokemonRepository there was an exception: $exception")
        }
        return pokemonList
    }

    override suspend fun getPokemon(id: String): Pokemon? {
        try {
            val response = dataSource.getPokemon(id)
            val body = response.body()
            if (body != null) {
                return body
            }
        } catch (exception: Exception) {
            Timber.d("PokemonRepository there was an exception: $exception")
        }
        return null
    }
}
