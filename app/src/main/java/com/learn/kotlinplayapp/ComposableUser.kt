package com.learn.kotlinplayapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun composableUser(user: User) {

    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp), elevation = 3.dp) {
        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = user.name)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = user.email)
        }
    }

}