package com.sx.datasource

import kotlin.reflect.KClass

interface NetworkClient {
    suspend fun <T: Any> get(url: String): T
    suspend fun <T: Any> post(url: String): T
}

object NetworkClientFactory {
    fun build(): NetworkClient {
        return NetworkClientImpl()
    }
}