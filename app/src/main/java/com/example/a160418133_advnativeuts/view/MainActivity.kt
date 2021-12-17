package com.example.a160418133_advnativeuts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.util.createNotification
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    init {
        instance = this
    }
    companion object {
        private var instance:MainActivity ?=null

        fun showNotification(title:String, content:String, icon:Int) {
            val channelID = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"
            val builder = NotificationCompat.Builder(instance!!.applicationContext, channelID)
                .apply {
                    setSmallIcon(icon)
                    setContentTitle(title)
                    setContentText(content)
                    setStyle(NotificationCompat.BigTextStyle())
                    priority = NotificationCompat.PRIORITY_DEFAULT

                    setAutoCancel(true)
                }
            val notif = NotificationManagerCompat.from(instance!!.applicationContext)
            notif.notify(1001, builder.build())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotification(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false, getString(R.string.app_name), "Notification Features")

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
        bottomNav.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout) || super.onSupportNavigateUp()
    }
}