package com.katyshevtseva.features_content.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.katyshevtseva.features_content.ComponentContainer
import com.katyshevtseva.features_content.R
import com.katyshevtseva.features_content.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var activeNavItemId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ComponentContainer.initComponent(application)

        setupBottomNavigationView()

        selectItem(R.id.navigation_home)
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId != activeNavItemId) {
                selectItem(item.itemId)
            }
            true
        }
    }

    private fun selectItem(navItemId: Int) {

        activeNavItemId = navItemId

        val fragment = when (navItemId) {
            R.id.navigation_home -> HomeFragment.newInstance()
            R.id.navigation_favorites -> FavouritesFragment.newInstance()
            R.id.navigation_account -> AccountFragment.newInstance()
            else -> throw RuntimeException("Unknown item id")
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainer, fragment)
            .commit()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
