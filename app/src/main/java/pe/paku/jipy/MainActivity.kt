package pe.paku.jipy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_main_nav)
        var navHostFragment = findNavController(R.id.nav_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment)
    }


}