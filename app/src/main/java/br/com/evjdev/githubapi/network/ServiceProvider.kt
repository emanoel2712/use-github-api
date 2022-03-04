package br.com.evjdev.githubapi.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class ServiceProvider {

    private val baseUrl = "https://api.github.com/"
    private val contentType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType)).build()

    fun <API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}