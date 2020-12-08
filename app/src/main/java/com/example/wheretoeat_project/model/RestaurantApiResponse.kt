package com.example.wheretoeat_project.model

data class RestaurantApiResponse(
    val current_page: Int,
    val per_page: Int,
    val restaurants: List<Restaurant>,
    val total_entries: Int
)


