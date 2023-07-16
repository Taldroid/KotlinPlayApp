package com.learn.kotlinplayapp

import android.util.Log
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {

    val TAG = UsersViewModel::class.java.simpleName
    val usersRepository = UsersRepository()

    fun getUsers() {
        // Simulate fetching items from a data source
        viewModelScope.launch {
            usersRepository.usersData.collect(collector = FlowCollector { users ->
                users.users.forEach() { user ->
                    Log.d(TAG, "Curr User Name: ${user.name}")
                }
            })
        }
    }
}
