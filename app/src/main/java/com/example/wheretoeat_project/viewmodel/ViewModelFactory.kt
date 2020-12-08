package com.example.wheretoeat_project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat_project.repository.ApiRepository

class ViewModelFactory(private val repository: ApiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ApiViewModel(repository) as T
    }
}