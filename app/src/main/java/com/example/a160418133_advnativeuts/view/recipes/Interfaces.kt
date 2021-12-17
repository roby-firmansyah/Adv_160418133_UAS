package com.example.a160418133_advnativeuts.view.recipes

import android.view.View
import com.example.a160418133_advnativeuts.model.Recipe

interface BtnDetailClickListener {
    fun onBtnDetailRecipes(v: View)
}

interface DeleteListener {
    fun onDel(v: View, obj: Recipe)
}

interface EditListener {
    fun onEdit(v: View, obj:Recipe)
}