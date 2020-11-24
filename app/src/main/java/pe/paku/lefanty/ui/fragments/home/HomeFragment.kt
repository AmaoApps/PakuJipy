package pe.paku.lefanty.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import pe.paku.lefanty.R
import pe.paku.lefanty.data.local.entities.reminder.Reminder
import pe.paku.lefanty.databinding.FragmentHomeBinding
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //Starting a viewmodel
    private val viewmodel by activityViewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        setupObservers()

        val demoReminder = Reminder(1, "tarjeta", "media", "codigito", "ayudita", Date())
        //val demoReminder2 = Reminder(2, "tarjetav2", "mediav2", "codigitov2", "ayuditav2", Date())

        viewmodel.saveReminder(demoReminder)
        //viewmodel.saveReminder(demoReminder2)

        val repositorios = viewmodel.getRemindersV2()


        return binding.root

    }

    private fun setupObservers() {
        viewmodel.listaReminders.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Toast.makeText(this.activity, "Cargado la lista de la bd", Toast.LENGTH_LONG).show()

        })
    }


}

