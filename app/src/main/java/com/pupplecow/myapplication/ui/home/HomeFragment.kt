package com.pupplecow.myapplication.ui.home

import android.os.Bundle
import android.os.strictmode.InstanceCountViolation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R

class HomeFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_home1,container,false)

        return view
    }


}