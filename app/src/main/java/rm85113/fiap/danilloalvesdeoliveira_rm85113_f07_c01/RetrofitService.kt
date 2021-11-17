package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

//    val BASE_URL: String = "https://pokeapi.co/api/v2/"
//    val retrofitFactory = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance() : Retrofit {
            val baseUrl: String = "https://pokeapi.co/api/v2/"
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}