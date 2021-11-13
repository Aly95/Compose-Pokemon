package pokemon.slick.data.repository.usecase

import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.model.PokemonBase
import pokemon.slick.data.repository.PokemonRepository

class GetPokemonUseCase (private val pokemonRepository: PokemonRepository) {
    suspend fun execute(): List<PokemonBase> = pokemonRepository.getPokemonList()
    suspend fun getIndividualPokemon(id: String): Pokemon? = pokemonRepository.getPokemon(id)
}