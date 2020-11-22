package pe.paku.lefanty.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pe.paku.lefanty.data.local.converters.ConvertersDB
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.data.local.entities.reminder.ReminderDao

@Database(
    entities = [Reminder::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ConvertersDB::class)
abstract class LefantyDB: RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    companion object{
        @Volatile
        private var INSTANCE: LefantyDB? = null

        fun getDatabase(context: Context): LefantyDB {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LefantyDB::class.java,
                    "LefantyDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}