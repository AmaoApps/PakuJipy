package pe.paku.lefanty.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import pe.paku.lefanty.data.local.database.LefantyDB
import pe.paku.lefanty.data.local.entities.reminder.ReminderDao
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



