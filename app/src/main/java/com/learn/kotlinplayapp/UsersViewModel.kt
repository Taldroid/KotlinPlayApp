package com.learn.kotlinplayapp

import android.util.Log
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {

    val TAG = UsersViewModel::class.java.simpleName
    val usersRepository = UsersRepository()

    // create a state flow of users with an empty list as the initial value
    private val _users = MutableStateFlow<List<User>>(emptyList())
    // expose the state flow as a read-only flow
    val users: StateFlow<List<User>> = _users

    init {
        getUsers()
    }
    fun getUsers() {

        // TODO: how do I get the data to the UI? collect twice?
        // Simulate fetching items from a data source
        viewModelScope.launch() {
            usersRepository.getUsers().collect(collector = { users ->
                users.users.forEach() { user ->
                    Log.d(TAG, "Curr User Name: ${user.name}")
                }

                _users.value = users.users
            })
        }
    }
}
