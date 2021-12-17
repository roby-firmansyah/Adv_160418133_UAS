package com.example.a160418133_advnativeuts.view.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.model.Recipe
import com.example.a160418133_advnativeuts.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_recipes_add.*

class RecipesAddFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        buttonAdd.setOnClickListener {
            var menu = Recipe(txtInputTitle.text.toString(), txtIngredients.text.toString(), txtPreparations.text.toString(), txtUrlImg.text.toString())
            viewModel.addMenu(menu)
            Toast.makeText(it.context, "Recipe Created", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_recipes_add, container, false)
//    }
}