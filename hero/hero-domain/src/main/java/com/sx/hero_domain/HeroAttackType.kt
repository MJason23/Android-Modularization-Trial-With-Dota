package com.sx.hero_domain

sealed class HeroAttackType(
    val uiValue: String
) {
    object Melee: HeroAttackType(uiValue = "Melee")
    object Ranged: HeroAttackType(uiValue = "Ranged")
    object Unknown: HeroAttackType(uiValue = "Unknown")

    companion object {
        fun getHeroAttackType(uiValue: String): HeroAttackType{
            return when(uiValue){
                Melee.uiValue -> {
                    Melee
                }
                Ranged.uiValue -> {
                    Ranged
                }
                else -> {
                    Unknown
                }
            }
        }
    }
}