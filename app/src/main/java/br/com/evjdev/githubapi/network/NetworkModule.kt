package br.com.evjdev.githubapi.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule() {

    @Provides
    fun providesServiceProvider(): ServiceProvider {
        val interceptorCustomImpl = InterceptorCustomImpl()
        return ServiceProvider(interceptorCustomImpl)
    }
}