package pe.paku.lefanty.usecases

import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.model.GithubRepositoryModel
import pe.paku.lefanty.data.model.ResultData
import pe.paku.lefanty.repositories.DataRepository
import pe.paku.lefanty.repositories.ReminderRepository
import javax.inject.Inject

class HomeUseCase
@Inject constructor(
    private val reminderRepository: ReminderRepository,
    //TODO Agregar logica para consultar desde la bd o desde el api, considerar agregar el repositorio de Reminder API

) {
    suspend fun getReminders(): ResultData<List<Reminder>> {
        val listReminders = reminderRepository.getAllRemindersv2()
        val resultData = if (!listReminders.isNullOrEmpty()){
            ResultData.Success(listReminders)
        } else {
            ResultData.Failed("Se encontró un Error, Intenta nuevamente")
        }

        return resultData
    }

    suspend fun saveReminder(reminder : Reminder){
        reminderRepository.saveReminder(reminder)
        //ResultData.Success(reminderSaved)
    }
}
