package com.example.wheretoeat_project.fragments.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.User
import com.example.wheretoeat_project.utils.Constants
import com.example.wheretoeat_project.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ProfileFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var userList: List<User>

    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var email: TextView
    private lateinit var address: TextView
    private lateinit var phone: TextView

    private lateinit var loginButton: Button

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
            //Log.d("USEREK", userList.toString())
            setData()
        })

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.apply {
            firstName = findViewById(R.id.firstName)
            lastName = findViewById(R.id.lastName)
            phone = findViewById(R.id.phone)
            email = findViewById(R.id.email)
            address = findViewById(R.id.address)
            loginButton = findViewById(R.id.login_button)
        }



        loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }

    }

    private fun setData() {

        for (u in userList) {
            if (u.email == Constants.U_EMAIL) {
                firstName.text = u.firstName
                lastName.text = u.lastName
                email.text = u.email
                address.text = u.address
                phone.text = u.phone
            }
        }

    }

}