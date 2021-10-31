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

    override suspend fun <T : Any> get(url: String, typeToken: TypeToken<T>): T {

        val requestString = httpClient.get<String> {
            url(url)
        }
        val responseString = requestString
        return Gson().fromJson(responseString, typeToken.type)
//        return Gson().fromJson(responseString) as T
    }

    override suspend fun <T : Any> post(url: String): T {
        val responseString = httpClient.post<String>{
            url(url)
        }
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(responseString, type)
    }
}

inline fun <T> Gson.fromJson(json: String): T =
    this.fromJson(json, object: TypeToken<T>() {}.type)