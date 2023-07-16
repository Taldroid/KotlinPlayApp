package com.learn.kotlinplayapp

import android.util.Log
import com.elyeproj.networkaccessevolution.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class UsersRepository {

    private val TAG = UsersRepository::javaClass.name

    val usersData : Flow<Users> = flow {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope?.launch {
            while (true) {
                Log.d(TAG, "Launch Fetch Started")

                val result = Network.fetchHttpResult(UsersApi().usersUrlBuilder, Users::class.java)
                Log.d(TAG, "Launch Fetch Finished")

                when (result) {
                    is Network.Result.NetworkError -> {
//                        view.updateScreen(result.message)
                        Log.d(TAG, "Launch Post Error Result")
                    }

                    is Network.Result.NetworkResult -> {
                        // TODO: complete
                        emit(result.message)
//                        view.updateScreen(result.message)
                        Log.d(TAG, "Launch Post SnapshotApplyResult.Success $result")
                    }
                }
            }
        }
    }
}