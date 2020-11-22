package pe.paku.lefanty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import pe.paku.lefanty.repositories.DataRepository
import pe.paku.lefanty.usecases.DataUseCase


@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideUseCase(dataRepository: DataRepository) : DataUseCase {
        return DataUseCase(dataRepository)
    }

}