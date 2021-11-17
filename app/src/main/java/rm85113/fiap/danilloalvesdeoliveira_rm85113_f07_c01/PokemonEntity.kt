package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import com.google.gson.annotations.SerializedName


data class PokemonAbility(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) {}

data class PokemonAbilities(
    @SerializedName("ability") val ability: PokemonAbility,
    @SerializedName("is_hidden") val is_hidden: String,
    @SerializedName("slot") val slot: Number,
) {}

data class PokemonForms(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) {}

data class PokemonSpecies(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) {}

data class PokemonOfficialArtWorkSprites(
    @SerializedName("front_default") val front_default: String,
) {}

data class PokemonOtherSprites(
    @SerializedName("dream_world") val dream_world: Any,
    @SerializedName("home") val home: Any,
    @SerializedName("official-artwork") val official_artwork: PokemonOfficialArtWorkSprites,
) {}

data class PokemonSprites(
    @SerializedName("back_default") val back_default: String,
    @SerializedName("back_female") val back_female: String,
    @SerializedName("back_shiny") val back_shiny: String,
    @SerializedName("back_shiny_female") val back_shiny_female: String,
    @SerializedName("front_default") val front_default: String,
    @SerializedName("front_female") val front_female: String,
    @SerializedName("front_shiny") val front_shiny: String,
    @SerializedName("front_shiny_female") val front_shiny_female: String,
    @SerializedName("other") val other: PokemonOtherSprites,
    @SerializedName("versions") val versions: Any,
) {}

data class PokemonType(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) {}

data class PokemonTypes(
    @SerializedName("slot") val slot: Number,
    @SerializedName("type") val type: PokemonType,
) {}

data class PokemonEntity (
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val base_experience: Number,
    @SerializedName("height") val height: Number,
    @SerializedName("id") val id: Number,
    @SerializedName("is_default") val is_default: Boolean,
    @SerializedName("location_area_encounters") val location_area_encounters: String,
    @SerializedName("order") val order: Number,
    @SerializedName("weight") val weight: Number,
    @SerializedName("abilities") val abilities: List<PokemonAbilities>,
    @SerializedName("forms") val forms: List<PokemonForms>,
    @SerializedName("game_indices") val game_indices: List<Any>,
    @SerializedName("held_items") val held_items: List<Any>,
    @SerializedName("moves") val moves: List<Any>,
    @SerializedName("species") val species: PokemonSpecies,
    @SerializedName("sprites") val sprites: PokemonSprites,
    @SerializedName("stats") val stats: List<Any>,
    @SerializedName("types") val types: List<PokemonTypes>,
){}