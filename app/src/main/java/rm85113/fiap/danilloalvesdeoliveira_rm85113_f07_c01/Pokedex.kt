package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.button.MaterialButton

class Pokedex : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)
        supportActionBar?.hide()

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

        /** clear the input text search */
        clearButton.setOnClickListener { searchInput.setText("") }


    }

    fun request () {
        /** get screens states containers */
        val loadingState: LinearLayout = findViewById(R.id.loadingState)
        val emptyState: LinearLayout = findViewById(R.id.emptyState)
        val errorState: LinearLayout = findViewById(R.id.searchError)
        val resultState: LinearLayout = findViewById(R.id.pokemonResult)
        val pokemonImage: ImageView = findViewById(R.id.pokemonImage);

    }

}
