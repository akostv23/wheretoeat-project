package com.example.wheretoeat_project.fragments.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.wheretoeat_project.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val image = requireArguments().get("image").toString()
        val name = requireArguments().get("name").toString()
        val address = requireArguments().get("address").toString()
        val city = requireArguments().get("city").toString()
        val state = requireArguments().get("state").toString()
        val area = requireArguments().get("area").toString()
        val postal_code = requireArguments().get("postal_code").toString()
        val country  = requireArguments().get("country").toString()
        val price = requireArguments().get("price").toString()
        val lat = requireArguments().get("lat").toString()
        val lng = requireArguments().get("lng").toString()
        val phone = requireArguments().get("phone").toString()
        val reserve_url = requireArguments().get("reserve_url").toString()


        view.apply {
            findViewById<TextView>(R.id.restaurant_name).text = name
            findViewById<TextView>(R.id.restaurant_address).text = address
            findViewById<TextView>(R.id.restaurant_city).text = city
            findViewById<TextView>(R.id.restaurant_state).text = state
            findViewById<TextView>(R.id.restaurant_area).text = area
            findViewById<TextView>(R.id.restaurant_postal_code).text = postal_code
            findViewById<TextView>(R.id.restaurant_country).text = country
            findViewById<TextView>(R.id.restaurant_price).text = price
            findViewById<TextView>(R.id.restaurant_url).text = reserve_url
            Glide.with(context)
                .load(image)
                .into(findViewById(R.id.restaurant_photo)).view
        }

        val mapButton =view.findViewById<ImageButton>(R.id.restaurant_gps)

        mapButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:$lat,$lng")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        val callButton = view.findViewById<ImageButton>(R.id.restaurant_phone)
        callButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }

        val reserveUrl = view.findViewById<TextView>(R.id.restaurant_url)
        reserveUrl.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(reserve_url))
            startActivity(browserIntent)
        }

        return view
    }



}