package pokemon.slick

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import pokemon.slick.data.model.Pokemon
import pokemon.slick.data.repository.usecase.GetPokemonUseCase
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    val pokemonListState = mutableStateOf(listOf<Pokemon>())

    fun getPokemonList() = liveData { emit(getPokemonUseCase.execute()) }

    fun getPokemon(pokemonUrlList: List<String>) = viewModelScope.launch {
        pokemonListState.value = pokemonUrlList.map { async { getPokemonUseCase.getIndividualPokemon(it) } }.awaitAll().mapNotNull { it }
    }
}
