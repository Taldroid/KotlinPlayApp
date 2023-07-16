package com.learn.kotlinplayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.learn.learncompose.ui.theme.LearnComposeTheme

class MainComposeActivity : ComponentActivity() {

    private val usersViewModel : UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UsersScreenComposable(usersViewModel)
                }
            }
        }
    }

    // create a fake view model class
    class FakeUsersViewModel : UsersViewModel() {

        override fun getUsers() {
            listOf(
                User(1, "Alice", "alice1", "alice_email.gmail.com", "0123456789"),
                User(2, "Bob", "bob1", "bob_email.gmail.com", "0123456789"),
                User(3, "Charlie", "charlie1", "charlie_email.gmail.com", "0123456789"),
            )
        }
        // use a hardcoded list of users
    }

    @Preview
    @Composable
    fun SimpleComposablePreview() {
        UsersScreenComposable(FakeUsersViewModel())
    }
}