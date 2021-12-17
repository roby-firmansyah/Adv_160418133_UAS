package com.example.a160418133_advnativeuts.view.recipes

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.model.Recipe
import com.example.a160418133_advnativeuts.viewmodel.DetailViewModel
import com.example.a160418133_advnativeuts.viewmodel.ListRecipeViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_recipes_add.*
import kotlinx.android.synthetic.main.fragment_recipes_list.*
import java.util.concurrent.TimeUnit

class RecipesListFragment : Fragment() {
    private lateinit var viewModel:ListRecipeViewModel
    private val recipelistAdapter = RecipesListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListRecipeViewModel::class.java)
        viewModel.refresh()
        recViewResep.layoutManager = LinearLayoutManager(context)
        recViewResep.adapter = recipelistAdapter
        observeViewModel()
        fabAddRecipes.setOnClickListener {
//            val action = RecipesListFragmentDirections.actionRecipesListFragmentToRecipesAddFragment();
//            Navigation.findNavController(it).navigate(action)
        }
    }
    fun observeViewModel() {

    }
}