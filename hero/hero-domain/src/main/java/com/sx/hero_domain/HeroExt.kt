package com.sx.hero_domain

fun Hero.minAttackDmg(): Int {
    return when(primaryAttribute){
        is HeroAttribute.Strength -> {
            baseAttackMin + baseStr
        }
        is HeroAttribute.Agility -> {
            baseAttackMin + baseAgi
        }
        is HeroAttribute.Intelligence -> {
            baseAttackMin + baseInt
        }
        is HeroAttribute.Unknown -> {
            0
        }
    }
}

fun Hero.maxAttackDmg(): Int {
    return when(primaryAttribute){
        is HeroAttribute.Strength -> {
            baseAttackMax + baseStr
        }
        is HeroAttribute.Agility -> {
            baseAttackMax + baseAgi
        }
        is HeroAttribute.Intelligence -> {
            baseAttackMax + baseInt
        }
        is HeroAttribute.Unknown -> {
            0
        }
    }
}