package pe.paku.jipy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pe.paku.jipy.repositories.DataRepository
import pe.paku.jipy.usecases.DataUseCase


@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideUseCase(dataRepository: DataRepository) : DataUseCase {
        return DataUseCase(dataRepository)
    }

}