package com.katyshevtseva.auth.domain.usecase

import com.katyshevtseva.auth.domain.repo.CredentialsRepository
import javax.inject.Inject

class CheckCredentialsUseCase @Inject constructor(
    private val repo: CredentialsRepository
) {

    operator fun invoke(email: String, pass: String): Boolean {
        return repo.validateCredentials(email, pass)
    }
}