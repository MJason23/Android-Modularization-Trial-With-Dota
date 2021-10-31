package com.sx.core

sealed class ProgressBarState {
    object Loading: ProgressBarState()
    object Idle: ProgressBarState()
}