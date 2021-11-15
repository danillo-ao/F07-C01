package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnPokedex = findViewById<Button>(R.id.pokedexButton)
        val btnAbout = findViewById<Button>(R.id.aboutButton)
        val btnCourse = findViewById<Button>(R.id.courseButton)

        btnPokedex.setOnClickListener {
            val intent = Intent(this, Pokedex::class.java)
            startActivity(intent)
        }
        btnAbout.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
        btnCourse.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            startActivity(intent)
        }
    }
}