package rm85113.fiap.danilloalvesdeoliveira_rm85113_f07_c01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class Course : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        supportActionBar?.hide()

        val btnBack: Button = findViewById(R.id.bBack)
        /** finish the activity when user press the back button at header */
        btnBack.setOnClickListener { finish() }

        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://www.fiap.com.br/graduacao/tecnologo/jogos-digitais/")

    }
}