package com.sx.hero_domain

sealed class HeroAttribute(
    val uiValue: String,
    val abbreviation: String
) {
    object Agility: HeroAttribute(uiValue = "Agility", abbreviation = "agi")
    object Strength: HeroAttribute(uiValue = "Strength", abbreviation = "str")
    object Intelligence: HeroAttribute(uiValue = "Intelligence", abbreviation = "int")
    object Unknown: HeroAttribute(uiValue = "Unknown", abbreviation = "unknown")
    
    companion object {
        fun getHeroAttrFromUiValue(uiValue: String): HeroAttribute{
            return when(uiValue){
                Agility.uiValue -> {
                    Agility
                }
                Strength.uiValue -> {
                    Strength
                }
                Intelligence.uiValue -> {
                    Intelligence
                }
                else -> Unknown
            }
        }

        fun getHeroAttrFromAbbreviation(abbreviation: String): HeroAttribute{
            return when(abbreviation){
                Agility.abbreviation -> {
                    Agility
                }
                Strength.abbreviation -> {
                    Strength
                }
                Intelligence.abbreviation -> {
                    Intelligence
                }
                else -> Unknown
            }
        }
    }
}