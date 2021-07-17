package com.example.navigationcomponentgyak

/**
 * Created by Dr. Schindler Ádám from Győr, Hungary

 * LinkedIn: https://www.linkedin.com/in/%C3%A1d%C3%A1m-dr-schindler-07b625207/

 * Github: https://github.com/SchindlerAdam
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigationcomponentgyak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        /** Toolbar for navigation back button
         * 0.) Change to action bar in themes.xml files to NoActionBar
         * 1.) See the activity_main.xml file for the layout properties
         * 2.) We have to create a navController for our navHost
         * 3.) After we have to set the toolbar for our activity
         * 4.) We call the setupActionBarWithNavController -> By calling this method, the title in the action bar will automatically be updated when the destination changes
         *     We will not see anything on the first screen, because it is a top level destination (no back button)
         * 5.) We override the onSupportNavigateUp() method below -> This method is called whenever the user chooses to navigate Up within the application's activity hierarchy from the action bar.
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(binding?.toolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}