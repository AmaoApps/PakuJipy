package pe.paku.lefanty.repositories

import androidx.lifecycle.LiveData
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.local.entities.reminder.ReminderDao

class ReminderRepository(private val reminderDao: ReminderDao){
    val reaAllReminder : LiveData<List<Reminder>> = reminderDao.readAllTable()

    //Usar suspend para usar las coroutines
    suspend fun addUser(reminder:Reminder){
        reminderDao.addReminder(reminder)
    }

}