package com.learn.kotlinplayapp

import com.elyeproj.networkaccessevolution.Network.addOthers
import okhttp3.HttpUrl

class UsersApi {

    val usersUrlBuilder = HttpUrl.Builder()
        .host("jsonplaceholder.typicode.com")
        .addPathSegment("users")
        .addOthers()
}