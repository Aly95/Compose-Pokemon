package pokemon.slick.data.repository

import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonBase

interface PokemonRepository {
    suspend fun getPokemonList(): List<PokemonBase>
    suspend fun getPokemon(id: String): Pokemon?
}