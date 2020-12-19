package com.example.wheretoeat_project.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat_project.data.UserDatabase
import com.example.wheretoeat_project.model.Favorites
import com.example.wheretoeat_project.repository.UserRepository
import com.example.wheretoeat_project.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository
    val readAllFavorites: LiveData<List<Favorites>>

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
        readAllFavorites = repository.readAllFavorites
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

    fun addFavorites(favorites: Favorites) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorites(favorites)
        }
    }

    fun deleteAllFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFavorites()
        }
    }

    fun deleteFavorite(favorites: Favorites) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavorite(favorites)
        }
    }

}