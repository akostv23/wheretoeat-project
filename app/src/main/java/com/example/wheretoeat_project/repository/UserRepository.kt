package com.example.wheretoeat_project.repository

import androidx.lifecycle.LiveData
import com.example.wheretoeat_project.data.UserDao
import com.example.wheretoeat_project.model.Favorites
import com.example.wheretoeat_project.model.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    val readAllFavorites: LiveData<List<Favorites>> = userDao.readAllFavorites()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    suspend fun addFavorites(favorites: Favorites) {
        userDao.addFavorites(favorites)
    }

    suspend fun deleteAllFavorites() {
        userDao.deleteAllFavorites()
    }

    suspend fun deleteFavorite(favorites: Favorites) {
        userDao.deleteFavorite(favorites)
    }

}