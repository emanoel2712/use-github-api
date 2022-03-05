package br.com.evjdev.githubapi.di

import br.com.evjdev.githubapi.data.api.GithubAPI
import br.com.evjdev.githubapi.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesGithubAPI(serviceProvider: ServiceProvider): GithubAPI {
        return serviceProvider.createService(GithubAPI::class.java)
    }
}