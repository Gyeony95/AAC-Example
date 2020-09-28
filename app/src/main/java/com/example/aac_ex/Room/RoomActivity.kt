package com.example.aac_ex.Room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aac_ex.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()
        //allowMainThreadQueries은 메인스레드에서도 룸디비를 사용할 수 있게 해주는것, 실전에서는 잘 안씀

        //it은 todolist
        db.todoDao().getAll().observe(this, Observer {
            tv_result.text = it.toString()
        })

        //데이터 업뎃되면 알아서 적용되니 리스너에서 추가 안해줘도 됨
        btn_add.setOnClickListener{
            //Dispatchers.IO 를 통해 백그라운드에서 돌아가게
            //lifecyleScope로 코루틴을 사용한 비동기처리 해줌
            lifecycleScope.launch(Dispatchers.IO) {
                db.todoDao().insert(Todo(et_todo.text.toString()))
            }

        }
    }
}