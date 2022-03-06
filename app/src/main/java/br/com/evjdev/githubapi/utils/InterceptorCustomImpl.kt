package br.com.evjdev.githubapi.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterceptorCustomImpl :
    InterceptorCustom {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(addHeader(chain.request()))
    }

    private fun addHeader(request: Request): Request {
        return request.newBuilder().addHeader("Content-Type", "application/json").build()
    }
}

