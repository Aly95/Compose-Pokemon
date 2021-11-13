package pokemon.slick.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.Normalizer

@Entity(tableName = "pokemonList")
data class PokemonList(
    @SerializedName("results")
    val pokemonList: List<PokemonBase> = listOf(),
) {
}

@Entity(tableName = "pokemonBase")
data class PokemonBase(
    @PrimaryKey
    @SerializedName("name")
    private val name: String?,
    @SerializedName("url")
    private val url: String
) {
    val pokemonId = url.takeLast(url.reversed().drop(1).indexOf("/").inc()).replace("/", "")
}

data class Pokemon(
    @SerializedName("base_experience")
    val baseExperience: Int? = 0,
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("held_items")
    val heldItems: List<Any>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("is_default")
    val isDefault: Boolean? = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("order")
    val order: Int? = 0,
    @SerializedName("past_types")
    val pastTypes: List<Any>? = listOf(),
    @SerializedName("sprites")
    val sprites: Sprites? = Sprites(),
    @SerializedName("weight")
    val weight: Int? = 0
)

data class Sprites(
    @SerializedName("back_default")
    val backDefault: String? = "",
    @SerializedName("back_female")
    val backFemale: Any? = null,
    @SerializedName("back_shiny")
    val backShiny: String? = "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any? = null,
    @SerializedName("front_default")
    val frontDefault: String? = "",
    @SerializedName("front_female")
    val frontFemale: Any? = null,
    @SerializedName("front_shiny")
    val frontShiny: String? = "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any? = null,
)