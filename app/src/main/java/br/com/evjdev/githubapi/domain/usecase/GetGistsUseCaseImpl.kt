package br.com.evjdev.githubapi.domain.usecase

import br.com.evjdev.githubapi.data.repository.GistsRepository
import br.com.evjdev.githubapi.domain.model.Gists
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetGistsUseCaseImpl @Inject constructor(private val gistsRepository: GistsRepository) :
    GetGistsUseCase {

    override suspend fun invoke(): Result<List<Gists>> {
        return try {
            Result.success(gistsRepository.getGists())
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
}