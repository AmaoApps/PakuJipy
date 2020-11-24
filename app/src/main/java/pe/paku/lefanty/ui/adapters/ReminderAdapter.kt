package pe.paku.lefanty.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.databinding.CardReminderBinding

class ReminderAdapter : ListAdapter<Reminder, ReminderAdapter.ViewHolder>(ReminderCallBack()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CardReminderBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Reminder) {
            binding.cardReminderTitle.text = item.code.toString()
            //binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardReminderBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}



class ReminderCallBack : DiffUtil.ItemCallback<Reminder>() {

    override fun areItemsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Reminder, newItem: Reminder): Boolean {
        return oldItem == newItem
    }


}