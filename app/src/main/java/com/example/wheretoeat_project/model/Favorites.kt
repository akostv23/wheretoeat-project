package com.example.wheretoeat_project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class Favorites(
    val email: String,
    val address: String,
    val city: String,
    val image_url: String,
    val name: String,
    val price: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
