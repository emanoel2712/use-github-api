package br.com.evjdev.githubapi.domain.usecase

import br.com.evjdev.githubapi.data.exception.GistsRepositoryException
import br.com.evjdev.githubapi.data.repository.GistsRepository
import br.com.evjdev.githubapi.domain.model.Gists
import java.lang.Exception

class GetGistsUseCase(private val repository: GistsRepository) {

    suspend operator fun invoke(): Result<Gists> {
        return try {
            Result.success(repository.getGists())
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}