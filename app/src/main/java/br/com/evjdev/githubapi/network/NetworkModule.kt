package br.com.evjdev.githubapi.network

import br.com.evjdev.githubapi.network.utils.InterceptorCustomImpl
import br.com.evjdev.githubapi.network.utils.NetworkConnectionImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule() {

    @Provides
    fun providesServiceProvider(networkConnectionImpl: NetworkConnectionImpl): ServiceProvider {
        val interceptorCustomImpl = InterceptorCustomImpl(networkConnectionImpl)
        return ServiceProvider(interceptorCustomImpl)
    }
}