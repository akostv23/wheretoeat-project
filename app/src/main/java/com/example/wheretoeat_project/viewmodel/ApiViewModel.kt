package com.example.wheretoeat_project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheretoeat_project.model.Restaurant
import com.example.wheretoeat_project.model.RestaurantApiResponse
import com.example.wheretoeat_project.repository.ApiRepository

class ApiViewModel(private val repository: ApiRepository) : ViewModel() {

    var restaurants: MutableLiveData<List<Restaurant>> = MutableLiveData()

    private fun restaurantConverter(restaurantApiResponse: RestaurantApiResponse): List<Restaurant> {
        val list = mutableListOf<Restaurant>()
        for (item in restaurantApiResponse.restaurants) {
            val rest = Restaurant(
                item.address,
                item.area,
                item.city,
                item.country,
                item.id,
                item.image_url,
                item.lat,
                item.lng,
                item.mobile_reserve_url,
                item.name,
                item.phone,
                item.postal_code,
                item.price,
                item.reserve_url,
                item.state
            )
            list.add(rest)
        }
        return list
    }

    private suspend fun getRestaurants(country: String){
        val restRepo = repository.getRestaurants(country)
        restaurants.value = restaurantConverter(restRepo)
    }

    suspend fun loadRestaurants(country: String){
        getRestaurants(country)
    }

}