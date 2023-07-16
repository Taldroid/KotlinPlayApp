package com.learn.kotlinplayapp.items

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.learn.kotlinplayapp.items.Item

@Composable
fun composableItem(item: Item) {

    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp), elevation = 3.dp) {
        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = item.title)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = item.description)
        }
    }

}