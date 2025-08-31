package com.katyshevtseva.auth.domain.repo

interface CredentialsRepository {

    fun validateCredentials(email: String, pass: String): Boolean
}