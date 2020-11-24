package pe.paku.lefanty.ui.fragments.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.model.GithubRepositoryModel
import pe.paku.lefanty.data.model.ResultData
import pe.paku.lefanty.repositories.ReminderRepository
import pe.paku.lefanty.usecases.DataUseCase
import pe.paku.lefanty.usecases.HomeUseCase


class HomeViewModel
@ViewModelInject constructor(
    //Agregar casos de uso
    private val homeUseCase: HomeUseCase
) : ViewModel (){


    val listaReminders = MutableLiveData<ResultData<List<Reminder>>>()

    fun getReminders(): LiveData<ResultData<List<Reminder>>>{
        return liveData<ResultData<List<Reminder>>> {
            emit(ResultData.Loading())
            emit(homeUseCase.getReminders())
        }
    }

    fun getRemindersV2() {
        viewModelScope.launch(Dispatchers.IO) {
            val reminders = homeUseCase.getReminders()
            listaReminders.postValue(reminders)
        }

    }

    fun saveReminder(reminder: Reminder){
        viewModelScope.launch(Dispatchers.IO) {
            homeUseCase.saveReminder(reminder)
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
