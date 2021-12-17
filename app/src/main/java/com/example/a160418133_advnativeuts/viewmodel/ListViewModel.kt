package com.example.a160418133_advnativeuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418133_advnativeuts.model.Recipe
import com.example.a160418133_advnativeuts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val recipeLD = MutableLiveData<List<Recipe>>()
    private var job = Job()

    fun refresh() {
        launch {
            val db = buildDB(getApplication())
            recipeLD.value = db.recipeDao().selectAllRecipe()
        }
    }

    fun clearTask(menu:Recipe) {
        launch {
            val db = buildDB(getApplication())
            db.recipeDao().deleteRecipe(menu)
            recipeLD.value = db.recipeDao().selectAllRecipe()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}