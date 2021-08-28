package com.raditya.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.raditya.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userView = binding.userView
        userView.setHasFixedSize(true)

        val users = UserData(this).getAllOfUser()
        val adapter = UserViewAdapter(users)

        userView.layoutManager = LinearLayoutManager(this)
        userView.adapter = adapter
    }
}