package com.elyeproj.networkaccessevolution

import com.google.gson.Gson
import com.learn.kotlinplayapp.Users
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.time.Duration

object Network {
    private val httpClient = OkHttpClient
            .Builder()
            .connectTimeout(Duration.ofSeconds(1L))
            .build()

    /*val errorHttpUrlBuilder = HttpUrl.Builder()
            .host("https://jsonplaceholder.typicodeADI.com/")
            .addPathSegment("x")
//            .addOthers()

    val crashHttpUrlBuilder = HttpUrl.Builder()
            .host("https://jsonplaceholder.typicodeLIA.com/")
            .addPathSegment("w")
//            .addOthers()*/

    fun HttpUrl.Builder.addOthers() = this
            .scheme("https")
            .addQueryParameter("action", "query")
            .addQueryParameter("format", "json")

    fun <T> fetchHttpResult(httpUrlBuilder: HttpUrl.Builder, returnType: Class<T>): Result<T> {
        val request = setupHttpRequest(httpUrlBuilder)
        val response = httpClient.newCall(request).execute()
        return deserializeResponse(response, returnType)
    }

    fun <T> fetchHttpResultAsync(
        httpUrlBuilder: HttpUrl.Builder,
        onResult: (result: Result<T>) -> Unit,
        onFailure: (error: IOException) -> Unit,
        returnType: Class<T>
    ) {
        val request = setupHttpRequest(httpUrlBuilder)
        httpClient.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, exception: IOException) {
                onFailure(exception)
            }

            override fun onResponse(call: Call, response: Response) {
                onResult(deserializeResponse(response, returnType))
            }
        })
    }

    private fun <T> deserializeResponse(response: Response, returnType: Class<T>): Result<T> {
        if (!response.isSuccessful) {
            return Result.NetworkError<T>("Error ${response.code}:${response.message}")
        }
        val raw = "{body: " +response.body?.string() + "}"
        val result = Result.NetworkResult(Gson().fromJson(raw, returnType))
        return result// Result.NetworkResult(result.toString())
    }

    private fun setupHttpRequest(
        httpUrlBuilder: HttpUrl.Builder): Request {
        val httpUrl = httpUrlBuilder.build()
        return Request.Builder().get().url(httpUrl).build()
    }

    sealed class Result<T> {
        class NetworkError<T>(val message: String) : Result<T>()
        class NetworkResult<T>(val message: T) : Result<T>()
    }
}
