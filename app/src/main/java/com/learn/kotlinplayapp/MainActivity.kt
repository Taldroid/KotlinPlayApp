package com.learn.kotlinplayapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.learn.kotlinplayapp.databinding.ActivityMainBinding
import com.learn.kotlinplayapp.items.ItemAdapter
import com.learn.kotlinplayapp.items.ItemsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val mainViewModel: ItemsViewModel by viewModels()
    private val usersViewModel : UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.viewModel = mainViewModel

        // Set the lifecycle owner to the activity to observe LiveData updates
        binding.lifecycleOwner = this

        usersViewModel.getUsers()

//        val items = mainViewModel.getItems()
        val composeView = binding.composeView
        composeView.setContent {

            // pass the view model to the composable function
            usersView(usersViewModel)
//            itemsView(mainViewModel, usersViewModel)
        }
//        adapter = ItemAdapter(viewModel.getItems())
//        recyclerView.adapter = adapter
    }

    fun printText(view: View) {

        if (view.tag == true) {
            view.setBackgroundColor(0)
            view.tag = false
            mainViewModel.selectedItem.set("")
        } else {
            view.setBackgroundColor(Color.BLUE)
            view.tag = true
            mainViewModel.selectedItem.set((view as LinearLayout).findViewById<TextView>(R.id.titleTextView).text.toString())
        }
    }
}
