package com.katyshevtseva.coursebase.presentation

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.katyshevtseva.auth.presentaion.AuthActivity
import com.katyshevtseva.features_content.presentation.MainActivity

class LauncherActivity : AppCompatActivity() {

    private val authLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            startActivity(MainActivity.newIntent(this))
            finish()
        } else {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authLauncher.launch(AuthActivity.newIntent(this))
    }
}