package com.example.wheretoeat_project.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.User
import com.example.wheretoeat_project.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ProfileFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var userList: List<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            userList = user
        })

        return view

    }

}