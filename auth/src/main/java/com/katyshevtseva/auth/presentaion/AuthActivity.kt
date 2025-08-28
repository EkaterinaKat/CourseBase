package com.katyshevtseva.auth.presentaion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.katyshevtseva.auth.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.authButton.setOnClickListener { onAuthSuccess() }
    }

    private fun onAuthSuccess() {
        setResult(RESULT_OK)
        finish()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AuthActivity::class.java)
    }
}