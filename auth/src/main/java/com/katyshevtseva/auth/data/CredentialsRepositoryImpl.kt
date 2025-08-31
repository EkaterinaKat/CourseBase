package com.katyshevtseva.auth.data

import com.katyshevtseva.auth.domain.repo.CredentialsRepository
import jakarta.inject.Inject

class CredentialsRepositoryImpl @Inject constructor() : CredentialsRepository {
    private val regex = Regex("^\\w+@\\w+\\.[a-zA-Z]+$")

    override fun validateCredentials(email: String, pass: String): Boolean {
        return !pass.trim().isEmpty() && isValidEmail(email)
    }

    private fun isValidEmail(email: String): Boolean {
        return regex.matches(email)
    }
}