package pe.paku.lefanty.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import pe.paku.lefanty.R
import pe.paku.lefanty.data.model.ResultData


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()

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

    private fun setUpNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_main_nav)
        val navHostFragment = findNavController(R.id.nav_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment)
    }


}