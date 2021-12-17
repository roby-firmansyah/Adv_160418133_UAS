package com.example.a160418133_advnativeuts.model

import androidx.room.*

@Dao
interface RecipesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe:Recipe)

    @Query("SELECT * FROM Recipe")
    suspend fun selectAllRecipe():List<Recipe>

    @Query("SELECT * FROM Recipe WHERE uuid=:id")
    suspend fun selectRecipe(id:Int):Recipe

    @Query("UPDATE Recipe SET title=:title, ingredients=:ingredients, preparations=:preparations, imgUrl=:url where uuid=:uuid")
    suspend fun editRecipe(uuid:Int, title:String, ingredients:String, preparations:String, url:String)

    @Delete
    suspend fun deleteRecipe(recipe:Recipe)
}