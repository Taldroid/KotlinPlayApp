package com.learn.kotlinplayapp

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
)

data class Users(val users: List<User>)