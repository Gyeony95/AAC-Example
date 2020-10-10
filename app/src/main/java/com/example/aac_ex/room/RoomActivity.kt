package com.example.aac_ex.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.aac_ex.R
import com.example.aac_ex.databinding.ActivityRoomBinding
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRoomBinding>(this,R.layout.activity_room)
        binding.lifecycleOwner = this//라이브데이터를 위한 것
/*
        val viewModel2 by lazy {
            ViewModelProvider(this, RoomViewModel.Factory(application)).get(RoomViewModel::class.java)
        }

 */
        val viewModel2 = ViewModelProvider(this).get(RoomViewModel::class.java)

        binding.viewModel = viewModel2


        //데이터 업뎃되면 알아서 적용되니 리스너에서 추가 안해줘도 됨
        btn_add.setOnClickListener{
            //Dispatchers.IO 를 통해 백그라운드에서 돌아가게
            //lifecyleScope로 코루틴을 사용한 비동기처리 해줌
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel2.insert(Todo(et_todo.text.toString()))
            }

        }
    }
}