package br.com.evjdev.githubapi.network

import br.com.evjdev.githubapi.network.utils.InterceptorCustom
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class ServiceProvider @Inject constructor(interceptorCustom: InterceptorCustom) {

    private val baseUrl = "https://api.github.com/"
    private val contentType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptorCustom)
    private val retrofit = Retrofit.Builder().client(okHttpClient.build()).baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType)).build()

    fun <API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}