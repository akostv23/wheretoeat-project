package com.example.wheretoeat_project.api

import com.example.wheretoeat_project.model.RestaurantApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("restaurants")
    suspend fun getRestaurants(@Query("country") countries: String): RestaurantApiResponse

}