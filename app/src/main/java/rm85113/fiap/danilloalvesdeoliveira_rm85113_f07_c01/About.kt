package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.hide()

        val btnBack: Button = findViewById(R.id.bBack)
        /** finish the activity when user press the back button at header */
        btnBack.setOnClickListener { finish() }

    }
}