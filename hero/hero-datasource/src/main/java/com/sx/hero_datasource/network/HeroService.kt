package com.sx.hero_datasource.network

import com.sx.datasource.NetworkClientFactory
import com.sx.hero_domain.Hero
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface HeroService {
    suspend fun getHeroStats(): List<Hero>
}

object HeroServiceFactory {
    fun build(): HeroService {
        return HeroServiceImpl(
            httpClient = NetworkClientFactory.build()
        )
    }
}