package com.example.a160418133_advnativeuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipe::class), version=1)
abstract class RecipesDB: RoomDatabase() {
    abstract fun recipeDao():RecipesDao

    companion object {
        @Volatile private var instance:RecipesDB ?= null
        private val LOCK = Any()

        private fun buildDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RecipesDB::class.java,
            "menudb"
        ).build()

        operator  fun invoke(context: Context) = Companion.instance ?: synchronized(LOCK) {
            instance ?: buildDB(context).also {
                instance = it
            }
        }
    }

}
