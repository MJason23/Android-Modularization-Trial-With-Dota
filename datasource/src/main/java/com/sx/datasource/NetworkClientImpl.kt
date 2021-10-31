package com.sx.datasource

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlin.reflect.KClass

/**
 * This NetworkClientImpl is using Ktor as http client
 * */
class NetworkClientImpl: NetworkClient {
    private val httpClient = HttpClient(Android) {
//        install(JsonFeature) {
//            serializer = KotlinxSerializer(
//                kotlinx.serialization.json.Json {
//                    ignoreUnknownKeys = true
//                }
//            )
//        }
    }

    override suspend fun <T : Any> get(url: String): T {

        val requestString = httpClient.get<String> {
            url(url)
        }
        val responseString = requestString
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(responseString, type)
    }

    override suspend fun <T : Any> post(url: String): T {
        val responseString = httpClient.post<String>{
            url(url)
        }
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(responseString, type)
    }
}