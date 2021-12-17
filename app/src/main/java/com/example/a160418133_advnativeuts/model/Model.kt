package com.example.a160418133_advnativeuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "ingredients")
    val ingredients:String,
    @ColumnInfo(name = "preparations")
    val preparations:String,
    @ColumnInfo(name = "imgUrl")
    val imgUrl:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}