package br.com.evjdev.githubapi.network.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class InterceptorCustomImpl @Inject constructor(private val networkConnection: NetworkConnection) :
    InterceptorCustom {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkConnection.hasInternet()) {
            throw Exception()
        }
        return chain.proceed(addHeader(chain.request()))
    }

    private fun addHeader(request: Request): Request {
        return request.newBuilder().addHeader("Content-Type", "application/json").build()
    }
}