package pe.paku.lefanty.ui.fragments.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.model.GithubRepositoryModel
import pe.paku.lefanty.data.model.ResultData
import pe.paku.lefanty.usecases.DataUseCase
import pe.paku.lefanty.usecases.HomeUseCase


class HomeViewModel
@ViewModelInject constructor(
    //Agregar casos de uso
    private val homeUseCase: HomeUseCase
) : ViewModel (){

    fun getReminders(): LiveData<ResultData<ArrayList<Reminder>>>{
        return liveData<ResultData<ArrayList<Reminder>>> {
            emit(ResultData.Loading())
            emit(homeUseCase.getReminders())
        }
    }
    //Agreganr las acciones que hace y que debemos observar
    /*
    fun getRepositoriesList(): LiveData<ResultData<GithubRepositoryModel>> {
        return liveData<ResultData<GithubRepositoryModel>> {
            emit(ResultData.Loading())
            emit(useCase.getRepositories())
        }

    }*/
}
