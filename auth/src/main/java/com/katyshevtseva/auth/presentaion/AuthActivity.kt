package com.katyshevtseva.auth.presentaion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.katyshevtseva.auth.ComponentContainer
import com.katyshevtseva.auth.databinding.ActivityAuthBinding
import com.katyshevtseva.auth.presentaion.viewModel.AuthViewModel
import com.katyshevtseva.auth.presentaion.viewModel.ViewModelFactory
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
    }

    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ComponentContainer.component.inject(this)

        setListeners()
        observeViewModel()
    }

    private fun setListeners() {
        binding.loginButton.setOnClickListener {
            viewModel.login(
                binding.emailEt.text.toString(),
                binding.passEt.text.toString()
            )
        }
    }

    private fun observeViewModel() {
        viewModel.errorLD.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.successLD.observe(this) {
            setResult(RESULT_OK)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AuthActivity::class.java)
    }
}