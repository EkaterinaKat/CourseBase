package com.katyshevtseva.coursebase.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.katyshevtseva.features_content.presentation.MainActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(MainActivity.newIntent(this))
        finish()
    }
}