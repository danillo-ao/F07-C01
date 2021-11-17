package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pokedex : AppCompatActivity() {

    private var emptyState: LinearLayout? = null;
    private var errorState: LinearLayout? = null;
    private var loadingState: LinearLayout? = null;
    private var resultState: LinearLayout? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)
        supportActionBar?.hide()

        this.emptyState = findViewById(R.id.emptyState)
        this.errorState = findViewById(R.id.searchError)
        this.resultState = findViewById(R.id.pokemonResult)
        this.loadingState = findViewById(R.id.loadingState)

        val btnBack: Button = findViewById(R.id.bBack)
        /** finish the activity when user press the back button at header */
        btnBack.setOnClickListener { finish() }

        /* get the search input and buttons components */
        val searchInput: EditText = findViewById(R.id.searchPokemon)
        val searchButton: MaterialButton = findViewById(R.id.bSearch)
        val clearButton: MaterialButton = findViewById(R.id.bClear)

        /** control the clear button visibility */
        searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val visibility = if (s.isNotEmpty()) View.VISIBLE else View.GONE;
                clearButton.visibility = visibility;
            }
        })

        /** trigger the search action when the user press the "submit" button at the keyboard */
        searchInput.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch();
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(v.windowToken, 0)
                true;
            } else {
                false;
            }
        }

        /** clear the input text search */
        clearButton.setOnClickListener { searchInput.setText("") }

        /** trigger the search action when the user press the search button at side of the input */
        searchButton.setOnClickListener { v ->
            doSearch();
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }


    /** This function will show the search success elements on the screen */
    private fun successLayout () {
        this.emptyState?.visibility = View.GONE;
        this.errorState?.visibility = View.GONE;
        this.loadingState?.visibility = View.GONE;
        this.resultState?.visibility = View.VISIBLE;
    }

    /** This function will show the error feedback on the screen */
    private fun errorLayout () {
        this.emptyState?.visibility = View.GONE;
        this.errorState?.visibility = View.VISIBLE;
        this.loadingState?.visibility = View.GONE;
        this.resultState?.visibility = View.GONE;
    }

    /** This function will show the loading on the screen */
    private fun loadingLayout () {
        this.emptyState?.visibility = View.GONE;
        this.errorState?.visibility = View.GONE;
        this.loadingState?.visibility = View.VISIBLE;
        this.resultState?.visibility = View.GONE;
    }

    /**
     * This function will effect the pokemon search.
     * Getting the search input value, and doing the request using the client. If the pokemon was found
     * it will show their image, name and ID.
     *
     * Also controlling the loading and error screen states.
     */
    private fun doSearch () {
        /** get screens states containers */
        val searchInput: EditText = findViewById(R.id.searchPokemon)

        /** result elements */
        val pokemonImage: ImageView = findViewById(R.id.pokemonImage);
        val pokemonName: TextView = findViewById(R.id.pokemonName);
        val pokemonId: TextView = findViewById(R.id.pokemonId);

        /** client */
        val retrofitClient = RetrofitService.getRetrofitInstance()
        val endpoint = retrofitClient.create(PokedexInterface::class.java)

        /** reset the input focus */
        searchInput.clearFocus();

        /* reset the screen stated, showing the correct states */
        loadingLayout();

        /** execute the search request */
        endpoint.searchPokemon(searchInput.text.toString()).enqueue(object: Callback<PokemonEntity> {
            override fun onFailure(call: Call<PokemonEntity>, t: Throwable) {
                errorLayout();
            }

            override fun onResponse(call: Call<PokemonEntity>, response: Response<PokemonEntity>) {
                response.body().let {
                    /** verify if the pokemon was found */
                    if (it?.id !== null) {
                        var zeros: String = if(it.id.toString().length >= 2) "0" else "00";
                        zeros = if(it.id.toString().length >= 3) "" else zeros;
                        Glide.with(applicationContext)
                            .load(it.sprites.other.official_artwork.front_default.toString())
                            .into(pokemonImage)

                        pokemonName.text = it.name
                        pokemonId.text = "#" + zeros + it.id.toString()
                        successLayout();
                    } else {
                        /** case the pokemon was not found, show the error screen */
                        errorLayout();
                    }

                }
            }
        })

    }

}
