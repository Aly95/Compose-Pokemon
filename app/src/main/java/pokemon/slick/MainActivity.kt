package pokemon.slick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pokemon.slick.ui.composables.PokemonRows
import pokemon.slick.ui.theme.MyComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.getPokemonList().observe(this) { listOfPokemon ->
                viewModel.getPokemon(listOfPokemon.map { it.pokemonId })
            }
            MyComposeTheme {
                PokemonRows(viewModel.pokemonListState)
            }
        }
    }
}





