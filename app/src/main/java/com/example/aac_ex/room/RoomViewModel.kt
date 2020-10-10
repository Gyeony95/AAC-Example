package com.example.aac_ex.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class RoomViewModel(application : Application) : AndroidViewModel(application) {

    private  val db = Room.databaseBuilder(application, AppDatabase::class.java, "database-name").build()
    //allowMainThreadQueries은 메인스레드에서도 룸디비를 사용할 수 있게 해주는것, 실전에서는 잘 안씀

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    var todos:LiveData<List<Todo>>

    init {
        todos = getAll()
    }

    //suspend를 사용하면 무조건 비동기 처리해야해서 코루틴 안에서 사용해야함
    suspend fun insert(todo: Todo){
        db.todoDao().insert(todo)
    }

    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RoomViewModel(application) as T
        }
    }
}