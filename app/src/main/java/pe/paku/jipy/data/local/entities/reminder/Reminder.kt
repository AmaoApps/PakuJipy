package pe.paku.jipy.data.local.entities.reminder

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "reminder_table")
data class Reminder(
  @PrimaryKey(autoGenerate = true)
  val id: Int,
  val type: String,
  val difficult: String,
  val code: String,
  val help: String,
  val schedule: Date?
){

}