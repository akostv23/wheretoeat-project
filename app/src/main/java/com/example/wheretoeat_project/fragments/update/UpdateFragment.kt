package com.example.wheretoeat_project.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.User
import com.example.wheretoeat_project.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName.setText(args.currentUser.firstName)
        view.updateLastName.setText(args.currentUser.lastName)
        view.updateEmail.setText(args.currentUser.email)

        view.update_button.setOnClickListener {
            //updateItem()
        }

        //Add Menu
        setHasOptionsMenu(true)

        return view
    }

//    private fun updateItem() {
//        val firstName = updateFirstName.text.toString()
//        val lastName = updateLastName.text.toString()
//        val email = updateEmail.text.toString()
//
//        if (inputCheck(firstName, lastName, email)) {
//            // Create User Object
//            val updateUser = User(args.currentUser.id, firstName, lastName, email)
//            // Update Current User
//            mUserViewModel.updateUser(updateUser)
//            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
//            // Navigate Back
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//
//        } else {
//            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }

    private fun inputCheck(firstName: String, lastName: String, email: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(email))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentUser.firstName}",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
        builder.create().show()
    }

}