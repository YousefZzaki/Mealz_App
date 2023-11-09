package com.example.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.entities.MealsResponse
import com.example.mealzapp.adapters.MealsAdapter
import com.example.mealzapp.databinding.ActivityMainBinding
import com.example.mealzapp.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var mealsAdapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel.getMealsList()


        lifecycleScope.launch {
            viewModel.stateFlow.collect {
                if (it != null) {
                    runOnUiThread {
                        binding?.progressBar?.visibility = VISIBLE
                    }
                    Log.e("mainTAG", it.toString())
                    mealsAdapter = MealsAdapter(it.categories)
                    binding?.rvCategories.apply {
                        this?.adapter = mealsAdapter
                        this?.layoutManager = GridLayoutManager(this@MainActivity, 2)

                    }
                    runOnUiThread {
                        binding?.progressBar?.visibility = INVISIBLE
                    }
                }

            }
        }


    }

    private fun initUi() {
        lifecycleScope.launch {

            viewModel.stateFlow.collect {
                Log.e("mTAG", it.toString())
            }
        }
    }

    private fun initRecyclerView(mealsResponse: MealsResponse?) {
        mealsAdapter = MealsAdapter(mealsResponse!!.categories)

        binding?.rvCategories.apply {
            this?.adapter = mealsAdapter
            this?.layoutManager = GridLayoutManager(this@MainActivity, 2)

        }
    }
}