package br.com.evjdev.githubapi.data.repository

import br.com.evjdev.githubapi.data.api.GithubAPI
import br.com.evjdev.githubapi.data.exception.GistsRepositoryException
import br.com.evjdev.githubapi.data.model.toDomain
import br.com.evjdev.githubapi.domain.model.Gists
import java.lang.Exception
import javax.inject.Inject

class GistsRepositoryImpl @Inject constructor(
    private val githubAPI: GithubAPI
) : GistsRepository {

    override suspend fun getGists(): List<Gists> {
        return try {
            githubAPI.getGists().map {
                it.toDomain()
            }

        } catch (ex: Exception) {
            throw GistsRepositoryException()
        }
    }
}