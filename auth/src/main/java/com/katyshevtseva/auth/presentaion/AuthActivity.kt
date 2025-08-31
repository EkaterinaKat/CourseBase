package com.katyshevtseva.auth.presentaion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.katyshevtseva.auth.ComponentContainer
import com.katyshevtseva.auth.databinding.ActivityAuthBinding
import com.katyshevtseva.auth.presentaion.util.OK_URL
import com.katyshevtseva.auth.presentaion.util.VK_URL
import com.katyshevtseva.auth.presentaion.util.browseUrl
import com.katyshevtseva.auth.presentaion.util.inputFilter
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

        setButtonListeners()
        setTextWatchers()
        observeViewModel()

        binding.emailEt.filters = arrayOf(inputFilter)
    }

    private fun setButtonListeners() {
        binding.loginButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
        binding.vkButton.setOnClickListener { browseUrl(this, VK_URL) }
        binding.okButton.setOnClickListener { browseUrl(this, OK_URL) }
    }

    private fun observeViewModel() {
        viewModel.credentialsAreValidLD.observe(this) {
            binding.loginButton.isEnabled = it
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            viewModel.onCredentialsInput(
                binding.emailEt.text.toString(),
                binding.passEt.text.toString()
            )
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun setTextWatchers() {
        binding.emailEt.addTextChangedListener(textWatcher)
        binding.passEt.addTextChangedListener(textWatcher)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, AuthActivity::class.java)
    }
}