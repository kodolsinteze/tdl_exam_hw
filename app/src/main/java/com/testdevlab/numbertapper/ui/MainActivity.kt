package com.testdevlab.numbertapper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.testdevlab.numbertapper.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val viewModel: GameViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("Main activity created")

        lifecycleScope.launch {
            viewModel.onError.collect { errorStringResource ->
                Toast.makeText(applicationContext, getString(errorStringResource),
                Toast.LENGTH_LONG).show()
            }
        }
    }
}
