package br.com.evjdev.githubapi.domain.usecase

import br.com.evjdev.githubapi.domain.model.Gists

interface GetGistsUseCase {
   suspend operator fun invoke(): Result<List<Gists>>
}