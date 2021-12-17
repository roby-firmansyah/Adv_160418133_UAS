package com.example.a160418133_advnativeuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.a160418133_advnativeuts.model.Recipe
import com.example.a160418133_advnativeuts.model.RecipesDB
import com.example.a160418133_advnativeuts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val recipeDetailLD = MutableLiveData<Recipe>()
    private  var job = Job()

    fun addMenu(recipe: Recipe) {
        launch {
            val db = Room.databaseBuilder(getApplication(), RecipesDB::class.java, "recipedb").build()
            db.recipeDao().insertAll(recipe)
        }
    }

    fun delete(recipe:Recipe)
    {
        launch {
            val db = buildDB(getApplication())
            db.recipeDao().deleteRecipe(recipe)
        }
    }

    fun edit(id:Int, title:String, ingredients:String, preparations:String, imgUrl:String)
    {
        launch {
            val db = buildDB(getApplication())
            db.recipeDao().editRecipe(id, title, ingredients, preparations, imgUrl)
        }
    }

    fun fetch(id:Int) {
        launch {
            val db = buildDB(getApplication())
            recipeDetailLD.value = db.recipeDao().selectRecipe(id)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}