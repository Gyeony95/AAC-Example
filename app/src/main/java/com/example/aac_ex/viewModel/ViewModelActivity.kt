package com.example.aac_ex.viewModel

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import com.example.aac_ex.R

class ViewModelActivity : AppCompatActivity() {
    private val viewModel : ViewModelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        viewModel.print()
    }
}


class ViewModelViewModel(application: Application): AndroidViewModel(application){
    fun print(){
        Log.e("LOG", "HELLO")
    }
}