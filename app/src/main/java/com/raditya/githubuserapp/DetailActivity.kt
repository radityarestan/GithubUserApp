package com.raditya.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val DETAIL_EXTRA_TAG = "com.raditya.githubuserapp.detailactivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetail: TextView = findViewById(R.id.detailUser)
        val user = intent.getParcelableExtra<User>(DETAIL_EXTRA_TAG)
        tvDetail.text = user?.name
    }
}