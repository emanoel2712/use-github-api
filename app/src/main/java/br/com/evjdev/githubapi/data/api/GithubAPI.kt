package br.com.evjdev.githubapi.data.api

import retrofit2.http.GET

interface GithubAPI {

    @GET
    suspend fun getGists()
}