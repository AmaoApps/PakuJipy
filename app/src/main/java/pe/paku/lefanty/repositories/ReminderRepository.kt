package pe.paku.lefanty.repositories

import androidx.lifecycle.LiveData
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.local.entities.reminder.ReminderDao
import pe.paku.lefanty.data.model.GithubRepositoryModel
import javax.inject.Inject

class ReminderRepository @Inject constructor(
    private val reminderDao: ReminderDao
){
    val reaAllReminder : LiveData<List<Reminder>> = reminderDao.readAllTable()

    suspend fun getAllReminders() :  LiveData<List<Reminder>> {
        return reminderDao.readAllTable()
    }

    suspend fun getAllRemindersv2() :  List<Reminder> {
        return reminderDao.readAllTablev2()
    }

    //Usar suspend para usar las coroutines
    suspend fun saveReminder(reminder:Reminder){
        reminderDao.addReminder(reminder)
    }


}