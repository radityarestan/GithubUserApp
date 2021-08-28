package com.raditya.githubuserapp

import android.content.Intent
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
        showUserList()
    }

    private fun showUserList() {
        val userView = binding.userView
        userView.setHasFixedSize(true)

        val users = UserData(this).getAllOfUser()
        val onItemCallback = object: UserViewAdapter.OnItemCallback{
            override fun onItemCalled(user: User) {
                val moveToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                moveToDetail.putExtra(DetailActivity.DETAIL_EXTRA_TAG, user)
                startActivity(moveToDetail)
            }
        }
        val adapter = UserViewAdapter(onItemCallback, users)

        userView.layoutManager = LinearLayoutManager(this)
        userView.adapter = adapter
    }
}