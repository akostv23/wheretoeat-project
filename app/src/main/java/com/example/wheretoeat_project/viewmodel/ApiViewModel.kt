package com.example.wheretoeat_project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat_project.model.Cities
import com.example.wheretoeat_project.model.Restaurant
import com.example.wheretoeat_project.model.RestaurantApiResponse
import com.example.wheretoeat_project.repository.ApiRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel(private val repository: ApiRepository) : ViewModel() {

    var restaurants: MutableLiveData<List<Restaurant>> = MutableLiveData()

    private fun restaurantConverter(restaurantApiResponse: RestaurantApiResponse): List<Restaurant> {
        val list = mutableListOf<Restaurant>()
        for (i in restaurantApiResponse.restaurants) {
            val rest = Restaurant(
                i.address,
                i.area,
                i.city,
                i.country,
                i.id,
                i.image_url,
                i.lat,
                i.lng,
                i.mobile_reserve_url,
                i.name,
                i.phone,
                i.postal_code,
                i.price,
                i.reserve_url,
                i.state
            )
            list.add(rest)
        }
        return list
    }

    private suspend fun getRestaurants(city: String){
        val restRepo = repository.getRestaurants(city)
        restaurants.value = restaurantConverter(restRepo)
    }

    suspend fun loadRestaurants(city: String){
        getRestaurants(city)
    }

}