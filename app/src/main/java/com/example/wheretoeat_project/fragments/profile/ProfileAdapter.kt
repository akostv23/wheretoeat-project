package com.example.wheretoeat_project.fragments.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.fragments.list.ListFragmentDirections
import com.example.wheretoeat_project.model.User
import kotlinx.android.synthetic.main.profile_layout.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        //Glide.with(holder.itemView.context).load(currentItem.profileImageView).into(holder.image).view
        //holder.itemView.firstName.text = currentItem.firstName
        //holder.itemView.lastName.text = currentItem.lastName
        //holder.itemView.email.text = currentItem.email

        holder.itemView.profileLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}