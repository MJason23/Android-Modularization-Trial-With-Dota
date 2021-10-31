package com.sx.hero_datasource.network

import com.sx.datasource.NetworkClient
import com.sx.hero_datasource.HeroDto
import com.sx.hero_datasource.toHero
import com.sx.hero_domain.Hero
import io.ktor.client.*
import io.ktor.client.request.*
import com.google.gson.reflect.TypeToken

class HeroServiceImpl(
    private val httpClient: NetworkClient
) : HeroService {
    override suspend fun getHeroStats(): List<Hero> {
        val typedToken = object : TypeToken<List<HeroDto>>() {}
        return httpClient.get<List<HeroDto>>(Endpoints.HERO_STATS, typedToken).map {
            it.toHero()
        }
    }
}