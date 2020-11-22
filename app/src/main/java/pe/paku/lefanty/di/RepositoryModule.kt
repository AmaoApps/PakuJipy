package pe.paku.lefanty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pe.paku.lefanty.data.api.ApiService
import pe.paku.lefanty.repositories.DataRepository

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideDataRepo(apiService : ApiService) : DataRepository {
        return DataRepository(apiService)
    }



}