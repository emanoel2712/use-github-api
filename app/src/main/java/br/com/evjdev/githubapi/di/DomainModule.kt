package br.com.evjdev.githubapi.di

import br.com.evjdev.githubapi.data.repository.GistsRepository
import br.com.evjdev.githubapi.data.repository.GistsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGistsRepository(
        gistsRepositoryImpl: GistsRepositoryImpl
    ): GistsRepository
}