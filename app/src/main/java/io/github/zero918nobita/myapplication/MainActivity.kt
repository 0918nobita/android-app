package io.github.zero918nobita.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { textView.text = getString(R.string.clicked_msg) }
    }
}
