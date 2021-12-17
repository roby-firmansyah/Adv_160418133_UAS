package com.example.a160418133_advnativeuts.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.model.RecipesDB
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

val DB_NAME = "recipedb"

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `usertable` (`id` INTEGER NOT NULL, `username` TEXT DEFAULT 0, PRIMARY KEY(`id`))")
    }
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view:ImageView, url:String?, pb:ProgressBar) {
    view.loadImage(url,pb)
}

fun buildDB(context: Context):RecipesDB {
    val db = Room.databaseBuilder(context,
        RecipesDB::class.java, DB_NAME).build()
    return db
}

fun createNotification(context: Context, importance:Int, showBadge:Boolean, name:String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelID = "${context.packageName}-$name"
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)

        val notifManager = context.getSystemService(NotificationManager::class.java)
        notifManager.createNotificationChannel(channel)
    }
}

fun ImageView.loadImage(url: String?, progressBar:ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object:Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}