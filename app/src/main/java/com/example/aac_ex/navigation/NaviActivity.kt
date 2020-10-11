package com.example.aac_ex.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.aac_ex.R

class NaviActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragmet) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    //뒤로가기
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragmet)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


}