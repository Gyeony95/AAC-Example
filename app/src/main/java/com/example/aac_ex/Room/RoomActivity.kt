package com.example.aac_ex.Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aac_ex.R
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").allowMainThreadQueries().build()

        tv_result.setText(db.todoDao().getAll().toString())

        btn_add.setOnClickListener{
            db.todoDao().insert(Todo(et_todo.text.toString()))
            tv_result.text = db.todoDao().getAll().toString()
        }
    }
}