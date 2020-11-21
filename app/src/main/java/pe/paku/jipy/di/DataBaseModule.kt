package pe.paku.jipy.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import pe.paku.jipy.data.local.database.LefantyDB
import pe.paku.jipy.data.local.entities.reminder.ReminderDao
import pe.paku.jipy.utils.NetworkConstants
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext appContext: Context) : LefantyDB {
        return Room.databaseBuilder(
            appContext,
            LefantyDB::class.java,
            "LefantyDB"
        ).build()
    }


    @Provides
    fun provideRepositoryDao(lefantyDB: LefantyDB): ReminderDao {
        return lefantyDB.reminderDao()
    }

}



