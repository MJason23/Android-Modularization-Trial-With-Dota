package com.sx.hero_interactors

import com.sx.hero_datasource.network.HeroServiceFactory

object HeroInteractorsFactory {
    fun build(): HeroInteractors {
        val service = HeroServiceFactory.build()
        val getHeroesUseCase = GetHeroes(service)
        return HeroInteractors(getHeroesUseCase)
    }
}