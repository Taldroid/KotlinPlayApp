package com.learn.kotlinplayapp.items

class FakeItemsRepository {

    fun getItems(): List<Item> {
        // Simulate fetching items from a data source
        return listOf(
            Item("Item 1", "Description 1"),
            Item("Item 2", "Description 2"),
            Item("Item 3", "Description 3"),
            Item("Item 4", "Description 4")
        )
    }
}