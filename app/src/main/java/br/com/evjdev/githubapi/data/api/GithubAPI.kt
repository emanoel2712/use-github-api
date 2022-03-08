package br.com.evjdev.githubapi.data.api

import br.com.evjdev.githubapi.data.model.GistsResponse
import retrofit2.http.GET

interface GithubAPI {

    @GET("/gists")
    suspend fun getGists(): List<GistsResponse>
}