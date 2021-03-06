package com.example.wheretoeat_project.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.Restaurant
import com.example.wheretoeat_project.repository.ApiRepository
import com.example.wheretoeat_project.viewmodel.ApiViewModel
import com.example.wheretoeat_project.viewmodel.UserViewModel
import com.example.wheretoeat_project.viewmodel.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListFragment : Fragment(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    private val mUserViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val navBar: BottomNavigationView? = this.activity?.findViewById(R.id.bottomNavigationView)
        navBar!!.visibility = View.VISIBLE

        //RecyclerView
        val adapter = ListAdapter(mUserViewModel)
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ApiViewModel
        launch {
            val repository = ApiRepository()
            val factory = ViewModelFactory(repository)
            val restaurantViewModel =
                ViewModelProvider(requireActivity(), factory).get(ApiViewModel::class.java)
            restaurantViewModel.loadRestaurants("US")
            lateinit var restList: List<Restaurant>
            restaurantViewModel.restaurants.observe(requireActivity(), { list ->
                restList = list
                adapter.setData(restList)
            })
        }

        //Add Button User
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

}