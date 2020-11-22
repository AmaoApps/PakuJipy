package pe.paku.lefanty.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pe.paku.lefanty.data.model.GithubRepositoryModel
import pe.paku.lefanty.data.model.ResultData
import pe.paku.lefanty.usecases.DataUseCase


class MainViewModel
@ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    //En los ViewModels van las coroutines
    fun getRepositoriesList(): LiveData<ResultData<GithubRepositoryModel>> {
        return liveData<ResultData<GithubRepositoryModel>> {
            emit(ResultData.Loading())
            emit(useCase.getRepositories())
        }

    }
}

