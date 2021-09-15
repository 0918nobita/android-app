package io.github.zero918nobita.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(MainViewModel::class.java)

        val textView = findViewById<TextView>(R.id.text)
        viewModel.text.onEach {
            textView.text = it
        }.launchIn(lifecycleScope)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { viewModel.updateText() }
    }
}
