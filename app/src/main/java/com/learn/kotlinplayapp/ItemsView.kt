package com.learn.kotlinplayapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun itemsView(itemsViewModel: ItemsViewModel, usersViewModel: UsersViewModel) {
    val items = remember { itemsViewModel.getItems()}
    LazyColumn() {
        items(items = items, itemContent = {
            composableItem(item = it)
        })}

//    CoroutineScope(LifecycleCoroutineScope().coroutineContext).launch {
//        usersViewModel.getUsers()
//    }
}