package pe.paku.lefanty.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import pe.paku.lefanty.R
import pe.paku.lefanty.data.model.ResultData
import pe.paku.lefanty.databinding.BottomSheetAddBinding
import pe.paku.lefanty.ui.fragments.home.BottomDialogAddFragment


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
        setUpAddButtonFab()

        /*
        val repositorios = mainViewModel.getRepositoriesList()
        repositorios.observe( this, Observer { resultData ->
            when(resultData){
                is ResultData.Loading -> {
                    Log.d("MAinActivity", "Loading")
                }
                is ResultData.Success -> {
                    Log.d("MAinActivity", "Success")
                    Log.d("MAinActivity", "data ".plus(Gson().toJson(resultData.data)))
                }
                is ResultData.Failed -> {
                    Log.d("MAinActivity", "Failed -> ".plus(resultData.message))
                }
                is ResultData.Exception -> {
                    Log.d("MAinActivity", "Exception".plus(resultData.message))
                }
            }

        })*/
    }

    private fun setUpAddButtonFab() {
        val buttonAddFab = findViewById<FloatingActionButton>(R.id.fab_add_button)
        buttonAddFab.setOnClickListener {
            BottomDialogAddFragment().apply {
                show(supportFragmentManager, tag)
            }
        }
    }

    private fun setUpNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_main_nav)
        val navHostFragment = findNavController(R.id.nav_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment)
    }


}