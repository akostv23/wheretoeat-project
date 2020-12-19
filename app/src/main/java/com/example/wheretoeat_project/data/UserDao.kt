package com.example.wheretoeat_project.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.wheretoeat_project.model.Favorites
import com.example.wheretoeat_project.model.User


@Dao
interface UserDao {

    //USERS

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    //FAVORITES

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorites(favorites: Favorites)

    @Query("SELECT * FROM favorites_table ORDER BY id ASC")
    fun readAllFavorites(): LiveData<List<Favorites>>

    @Query("DELETE FROM favorites_table")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(favorites: Favorites)

}