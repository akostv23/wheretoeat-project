package com.example.wheretoeat_project.repository

import com.example.wheretoeat_project.api.RetrofitInstance
import com.example.wheretoeat_project.model.RestaurantApiResponse
import retrofit2.Response

class ApiRepository {

    suspend fun getRestaurants(country: String): RestaurantApiResponse {
        return RetrofitInstance.api.getRestaurants(country)
    }

}