package pe.paku.lefanty.repositories

import androidx.lifecycle.LiveData
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.local.entities.reminder.ReminderDao
import pe.paku.lefanty.data.model.GithubRepositoryModel

class ReminderRepository(private val reminderDao: ReminderDao){
    val reaAllReminder : LiveData<ArrayList<Reminder>> = reminderDao.readAllTable()

    suspend fun getAllReminders() :  LiveData<ArrayList<Reminder>> {
        return reminderDao.readAllTable()
    }

    suspend fun getAllRemindersv2() :  ArrayList<Reminder> {
        return reminderDao.readAllTablev2()
    }

    //Usar suspend para usar las coroutines
    suspend fun addUser(reminder:Reminder){
        reminderDao.addReminder(reminder)
    }

}