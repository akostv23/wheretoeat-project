package com.example.wheretoeat_project.fragments.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.Restaurant
import com.example.wheretoeat_project.repository.ApiRepository
import com.example.wheretoeat_project.viewmodel.ApiViewModel
import com.example.wheretoeat_project.viewmodel.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navBar: BottomNavigationView? = this.activity?.findViewById(R.id.bottomNavigationView)
        navBar!!.visibility = View.GONE

        //Splash waiting
        launch {
           delay(5000)
            findNavController().navigate(R.id.action_splashFragment_to_listFragment)
        }

    }
}