package com.example.aac_ex.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aac_ex.R
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener{

            //세이프 아그 사용해서 값 넘겨 주기
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Hello")
            findNavController().navigate(action)

            //아래는 아그 사용하기 전에 쓰던거
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }

    }
  
}