package com.example.wheretoeat_project.fragments.login

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.User
import com.example.wheretoeat_project.utils.Constants
import com.example.wheretoeat_project.viewmodel.UserViewModel

class LoginFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var userList: List<User>
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            userList = user
            //Log.d("USEREK", userList.toString())
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)
        val login_button = view.findViewById<Button>(R.id.login_bttn)

        login_button.setOnClickListener {

            if (isAdded(
                    email.text.toString(),
                    password.text.toString()
                ) != null
            ) {
                findNavController().navigate(R.id.action_loginFragment_to_profileFragment, bundle)
                Constants.isLoggedIn = true
            }
            else
            {
                Toast.makeText(requireContext(), "NOT REGISTERED!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_addFragment, bundle)
            }

        }

    }

    fun isAdded(email: String, password: String): User? {

        for (u in userList) {
            if (u.email == email && u.password == password) {
                bundle = bundleOf(
                    "First Name" to u.firstName,
                    "Last Name" to u.lastName,
                    "Email" to u.email,
                    "Address" to u.address,
                    "Phone" to u.phone,
                    "Password" to u.password
                )

                Constants.U_EMAIL = u.email.toString()

                return u
            }
        }

        return null
    }


}