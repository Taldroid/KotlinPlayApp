package com.learn.kotlinplayapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun UsersScreenComposable(usersViewModel: UsersViewModel) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // create multiple references using createRefs
        val (header, usersList) = createRefs()

        Row(
            modifier = Modifier
                .height(100.dp)
                .constrainAs(ref = header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically // add this parameter
        ) {
            Text("Users:")
        }
//        Text("Users:", modifier = Modifier.height(100.dp).constrainAs(ref = header) {
//            top.linkTo(parent.top)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//        })

        /*Box(modifier = Modifier
            .height(250.dp)
            .constrainAs(ref = header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }) {

            Text("Users:", modifier = Modifier.align(Alignment.Center).constrainAs(ref = header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })
        }*/

//        Text("Users:")
        Box(modifier = Modifier
            .constrainAs(ref = usersList) {
                top.linkTo(header.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

            usersView(usersViewModel = usersViewModel)
        }
    }
}