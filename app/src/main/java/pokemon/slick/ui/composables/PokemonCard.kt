package pokemon.slick.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pokemon.slick.data.model.Pokemon

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val image = ImageLoader(url = pokemon.sprites?.frontDefault.orEmpty())
            image.value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    pokemon.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.BottomCenter
                )
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 450f,
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(pokemon.name.orEmpty(), style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}
