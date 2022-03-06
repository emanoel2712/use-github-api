package br.com.evjdev.githubapi.data.repository

import br.com.evjdev.githubapi.data.api.GithubAPI
import br.com.evjdev.githubapi.data.exception.RepositoryException
import br.com.evjdev.githubapi.data.model.toDomain
import br.com.evjdev.githubapi.domain.model.Gists
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GistsRepositoryImpl @Inject constructor(
    private val githubAPI: GithubAPI
) : GistsRepository {

    override suspend fun getGists(): List<Gists> {
        return try {
            githubAPI.getGists().map {
                it.toDomain()
            }
        } catch (e: IOException) {
            throw RepositoryException.NetworkException
        } catch (e: HttpException) {
            throw RepositoryException.HttpException
        }
    }
}
