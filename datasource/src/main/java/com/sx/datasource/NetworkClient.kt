package com.sx.datasource

import com.google.gson.reflect.TypeToken
import kotlin.reflect.KClass

interface NetworkClient {
    suspend fun <T: Any> get(url: String, typeToken: TypeToken<T>): T
    suspend fun <T: Any> post(url: String): T
}

object NetworkClientFactory {
    fun build(): NetworkClient {
        return NetworkClientImpl()
    }
}