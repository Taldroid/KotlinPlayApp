package com.learn.kotlinplayapp

import android.util.Log
import com.elyeproj.networkaccessevolution.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch

class UsersRepository {

    private val TAG = UsersRepository::javaClass.name

    fun getUsers(): Flow<Users> {

        return channelFlow {
            val coroutineScope = CoroutineScope(Dispatchers.IO)
            coroutineScope.launch {
//            while (true) {
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
                        send(result.message)
//                        view.updateScreen(result.message)
                        Log.d(TAG, "Launch Post SnapshotApplyResult.Success $result")
                    }
                }
//            }
                close()
            }

            awaitClose {
                // Perform any cleanup tasks if needed
            }
        }
    }
}