package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexInterface {

    @GET("pokemon/{search}")
    fun searchPokemon(@Path("search") search : String): Call<PokemonEntity>

}