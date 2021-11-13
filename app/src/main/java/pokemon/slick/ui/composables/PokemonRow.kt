package pokemon.slick.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.dp
import pokemon.slick.data.model.Pokemon

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonRows(pokemonList: MutableState<List<Pokemon>>) {
    Row() {
        LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
            itemsIndexed(pokemonList.value) { index, item ->
                PokemonCard(item)
            }
        }
    }
}
