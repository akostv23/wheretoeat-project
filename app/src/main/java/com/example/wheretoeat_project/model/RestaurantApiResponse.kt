package com.example.wheretoeat_project.model

data class RestaurantApiResponse(
    val page: Int,
    val per_page: Int,
    val restaurants: List<Restaurant>,
    val total_entries: Int
)


