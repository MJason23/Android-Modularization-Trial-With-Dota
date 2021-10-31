package com.sx.hero_interactors

import com.sx.core.DataState
import com.sx.core.ProgressBarState
import com.sx.core.UIComponent
import com.sx.hero_datasource.network.HeroService
import com.sx.hero_domain.Hero
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

typealias Heroes = List<Hero>

class GetHeroes(
    private val service: HeroService
    //TODO: Add Caching here
) {
    fun execute(): Flow<DataState<Heroes>> = flow {
        try {
            emit(DataState.Loading<Heroes>(progressBarState = ProgressBarState.Loading))

            val heroes: Heroes = getHeroesFromRemote(this)
            //TODO: Get Heroes from Cache

            emit(DataState.Data(heroes))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                buildErrorResponse<Heroes>(e, "Error")
            )
        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
    }

    private suspend fun getHeroesFromRemote(flowCollector: FlowCollector<DataState<Heroes>>): Heroes {
        return try {
            service.getHeroStats()
        } catch (e: Exception) {
            e.printStackTrace()
            flowCollector.apply {
                emit(
                    buildErrorResponse(e, "Network Error")
                )
            }

            listOf()
        }
    }

    private fun <T> buildErrorResponse(e: Exception, title: String): DataState<T> {
        return DataState.Response(
            uiComponent = UIComponent.Dialog(
                title = title,
                description = e.message ?: "Unknown Error"
            )
        )
    }
}