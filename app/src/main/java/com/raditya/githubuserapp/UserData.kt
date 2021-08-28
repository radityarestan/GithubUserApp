package com.raditya.githubuserapp

import android.content.Context

class UserData(private val context: Context) {
    fun getAllOfUser(): ArrayList<User> {
        var listOfUsername = context.resources.getStringArray(R.array.username)
        var listOfName = context.resources.getStringArray(R.array.name)
        var listOfLocation = context.resources.getStringArray(R.array.location)
        var listOfCompany = context.resources.getStringArray(R.array.company)
        var repositories = context.resources.getStringArray(R.array.repository)
        var followers = context.resources.getStringArray(R.array.followers)
        var followings = context.resources.getStringArray(R.array.following)
        var avatars = context.resources.obtainTypedArray(R.array.avatar)

        val users = arrayListOf<User>()
        val numberOfUser = listOfUsername.size-1

        for (position in 0..numberOfUser) {
            val user = User(
                username = listOfUsername[position],
                name = listOfName[position],
                avatar = avatars.getResourceId(position, 0),
                company = listOfCompany[position],
                location = listOfLocation[position],
                repository = repositories[position].toInt(),
                follower = followers[position].toInt(),
                following = followings[position].toInt()
            )
            users.add(user)
        }

        return users
    }
}