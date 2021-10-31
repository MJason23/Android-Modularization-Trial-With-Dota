package com.sx.hero_domain

sealed class HeroRole(
    val uiValue: String
) {
    object Carry : HeroRole(uiValue = "Carry")

    object Escape : HeroRole(uiValue = "Escape")

    object Nuker : HeroRole(uiValue = "Nuker")

    object Initiator : HeroRole(uiValue = "Initiator")

    object Durable : HeroRole(uiValue = "Durable")

    object Disabler : HeroRole(uiValue = "Disabler")

    object Jungler : HeroRole(uiValue = "Jungler")

    object Support : HeroRole(uiValue = "Support")

    object Pusher : HeroRole(uiValue = "Pusher")

    object Unknown : HeroRole(uiValue = "Unknown")

    companion object {
        fun getHeroRole(uiValue: String): HeroRole {
            return when (uiValue) {
                Carry.uiValue -> {
                    Carry
                }
                Escape.uiValue -> {
                    Escape
                }
                Nuker.uiValue -> {
                    Nuker
                }
                Initiator.uiValue -> {
                    Initiator
                }
                Durable.uiValue -> {
                    Durable
                }
                Disabler.uiValue -> {
                    Disabler
                }
                Jungler.uiValue -> {
                    Jungler
                }
                Support.uiValue -> {
                    Support
                }
                Pusher.uiValue -> {
                    Pusher
                }
                else -> {
                    Unknown
                }
            }
        }
    }
}