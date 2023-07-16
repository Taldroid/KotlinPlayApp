package com.learn.kotlinplayapp

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class ItemsViewModel : ViewModel() {

    val TAG = ItemsViewModel::class.java.simpleName

    val selectedItem = ObservableField<String>()

    fun getItems(): List<Item> {
        // Simulate fetching items from a data source
        return FakeItemsRepository().getItems()
    }
}
