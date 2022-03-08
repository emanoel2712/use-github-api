package br.com.evjdev.githubapi.data.repository

import br.com.evjdev.githubapi.domain.model.Gists

interface GistsRepository {

    suspend fun getGists(): List<Gists>
}