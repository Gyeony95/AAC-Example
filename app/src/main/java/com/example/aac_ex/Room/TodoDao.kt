package com.example.aac_ex.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll():LiveData<List<Todo>>
    //관찰을 위해 LiveData<>로 감쌈
    @Insert
    fun insert(todo: Todo)
    @Update
    fun update(todo: Todo)
    @Delete
    fun delete(todo: Todo)

}