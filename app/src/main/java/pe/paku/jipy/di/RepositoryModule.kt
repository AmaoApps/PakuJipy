package pe.paku.jipy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pe.paku.jipy.data.api.ApiService
import pe.paku.jipy.repositories.DataRepository

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideDataRepo(apiService : ApiService) : DataRepository {
        return DataRepository(apiService)
    }



}