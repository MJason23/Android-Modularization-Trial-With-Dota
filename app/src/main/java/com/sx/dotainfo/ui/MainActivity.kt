package com.sx.dotainfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sx.core.DataState
import com.sx.core.Logger
import com.sx.core.ProgressBarState
import com.sx.core.UIComponent
import com.sx.dotainfo.ui.theme.DotaInfoTheme
import com.sx.hero_domain.Hero
import com.sx.hero_interactors.HeroInteractors
import com.sx.hero_interactors.HeroInteractorsFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : ComponentActivity() {

    private val heroes: MutableState<List<Hero>> = mutableStateOf(listOf())
    private val progressBarState: MutableState<ProgressBarState> = mutableStateOf(ProgressBarState.Idle)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getHeroes = HeroInteractorsFactory.build().getHeroes
        val logger = Logger("GetHeroesTest")
        getHeroes.execute().onEach { dataState ->
            when(dataState) {
                is DataState.Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is DataState.Data -> {
                    heroes.value = dataState.data ?: listOf()
                }
                is DataState.Loading -> {
                    progressBarState.value = dataState.progressBarState
                }

            }

        }.launchIn(CoroutineScope(IO))

        setContent {
            DotaInfoTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        items(heroes.value) { hero ->
                            Text(text = hero.localizedName)
                        }
                    }
                    if (progressBarState.value is ProgressBarState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

