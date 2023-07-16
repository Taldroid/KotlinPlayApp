package com.learn.kotlinplayapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

@Composable
fun usersView(usersViewModel: UsersViewModel) {

    // get the state flow from the view model
    val users = usersViewModel.users.collectAsState()
    // display the users in a lazy column
    LazyColumn {
        items(users.value) { user ->
            // display each user in a row
            composableUser(user)
        }
    }
}