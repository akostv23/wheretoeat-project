package com.example.wheretoeat_project.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wheretoeat_project.R
import com.example.wheretoeat_project.model.Restaurant

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var restaurantList = emptyList<Restaurant>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.restaurantImage)
        var name = itemView.findViewById<TextView>(R.id.restaurantName)
        var address = itemView.findViewById<TextView>(R.id.restaurantAddress)
        var price = itemView.findViewById<TextView>(R.id.restaurantPrice)
        var city = itemView.findViewById<TextView>(R.id.restaurantCity)
        var favorite = itemView.findViewById<ImageButton>(R.id.favoriteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = restaurantList[position]
        Glide.with(holder.itemView.context).load(currentItem.image_url).into(holder.image).view
        holder.name.text = currentItem.name
        holder.address.text = currentItem.address
        holder.price.text = "$".repeat(currentItem.price)
        holder.city.text = currentItem.city
        holder.favorite.setOnClickListener {
            holder.favorite.setImageResource(R.drawable.ic_favorite)
        }
        holder.favorite.setOnLongClickListener {
            holder.favorite.setImageResource(R.drawable.ic_favorite_empty)
            true
        }
        holder.itemView.setOnClickListener{
            val bundle = bundleOf(
                "image" to currentItem.image_url,
                "name" to currentItem.name,
                "address" to currentItem.address,
                "city" to currentItem.city,
                "state" to currentItem.state,
                "area" to currentItem.area,
                "postal_code" to currentItem.postal_code,
                "country" to currentItem.country,
                "price" to "$".repeat(currentItem.price),
                "lat" to currentItem.lat,
                "lng" to currentItem.lng
                )

            holder.itemView.findNavController().navigate(R.id.action_listFragment_to_detailsFragment, bundle)

        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    fun setData(restaurant: List<Restaurant>) {
        this.restaurantList = restaurant
        notifyDataSetChanged()
    }
}