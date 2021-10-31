package com.sx.hero_datasource

import com.google.gson.annotations.SerializedName
import com.sx.hero_datasource.network.Endpoints.BASE_URL
import com.sx.hero_domain.Hero
import com.sx.hero_domain.HeroAttackType
import com.sx.hero_domain.HeroAttribute
import com.sx.hero_domain.HeroRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class HeroDto(

    @SerialName("id")
    val id: Int,

    @SerialName("localized_name")
    val localized_name: String,

    @SerialName("primary_attr")
    val primary_attr: String,

    @SerialName("attack_type")
    val attack_type: String,

    @SerialName("roles")
    val roles: List<String>,

    @SerialName("img")
    val img: String,

    @SerialName("icon")
    val icon: String,

    @SerialName("base_health")
    val base_health: Float,

    @SerialName("base_health_regen")
    val base_health_regen: Float?,

    @SerialName("base_mana")
    val base_mana: Float,

    @SerialName("base_mana_regen")
    val base_mana_regen: Float?,

    @SerialName("base_armor")
    val base_armor: Float,

    @SerialName("base_mr")
    val base_mr: Float,

    @SerialName("base_attack_min")
    val base_attack_min: Int,

    @SerialName("base_attack_max")
    val base_attack_max: Int,

    @SerialName("base_str")
    val base_str: Int,

    @SerialName("base_agi")
    val base_agi: Int,

    @SerialName("base_int")
    val base_int: Int,

    @SerialName("str_gain")
    val str_gain: Float, // Strength gain per lvl

    @SerialName("agi_gain")
    val agi_gain: Float, // Agility gain per lvl

    @SerialName("int_gain")
    val int_gain: Float, // Intelligence gain per lvl

    @SerialName("attack_range")
    val attack_range: Int,

    @SerialName("projectile_speed")
    val projectile_speed: Int,

    @SerialName("attack_rate")
    val attack_rate: Float,

    @SerialName("move_speed")
    val move_speed: Int,

    @SerialName("turn_rate")
    val turn_rate: Float? = 0F,

    @SerialName("legs")
    val legs: Int, // How many legs does this hero have?

    @SerialName("turbo_picks")
    val turbo_picks: Int, // How many times picked for turbo matches?

    @SerialName("turbo_wins")
    val turbo_wins: Int, // How many times won a turbo match?

    @SerialName("pro_win")
    val pro_win: Int? = 0, // How many times won a pro match?

    @SerialName("pro_pick")
    val pro_pick: Int? = 0, // How many times picked in pro match?

    @SerializedName("1_pick")
    val firstPick: Int, // How many times picked first?

    @SerializedName("1_win")
    val firstWin: Int, // How many times picked first and won?

    @SerializedName("2_pick")
    val secondPick: Int, // How many times picked second?

    @SerializedName("2_win")
    val secondWin: Int, // How many times picked second and won?

    @SerializedName("3_pick")
    val thirdPick: Int, // How many times picked third?

    @SerializedName("3_win")
    val thirdWin: Int, // How many times picked third and won?

    @SerializedName("4_pick")
    val fourthPick: Int, // How many times picked in fourth round?

    @SerializedName("4_win")
    val fourthWin: Int, // How many times picked in fourth round and won?

    @SerializedName("5_pick")
    val fifthPick: Int, // How many times picked fifth?

    @SerializedName("5_win")
    val fifthWin: Int, // How many times picked fifth and won?

    @SerializedName("6_pick")
    val sixthPick: Int, // How many times picked sixth?

    @SerializedName("6_win")
    val sixthWin: Int, // How many times picked sixth and won?

    @SerializedName("7_pick")
    val seventhPick: Int, // How many times picked seventh?

    @SerializedName("7_win")
    val seventhWin: Int, // How many times picked seventh and won?

    @SerializedName("8_pick")
    val eighthPick: Int, // How many times picked eighth round?

    @SerialName("8_win")
    val eighthWin: Int, // How many times picked eighth and won?
)

fun HeroDto.toHero(): Hero {
    return Hero(
        id = id,
        localizedName = localized_name,
        primaryAttribute = HeroAttribute.getHeroAttrFromAbbreviation(primary_attr),
        attackType = HeroAttackType.getHeroAttackType(attack_type),
        roles = roles.map { HeroRole.getHeroRole(it) },
        img = "$BASE_URL$img",
        icon = "$BASE_URL$icon",
        baseHealth = base_health,
        baseHealthRegen = base_health_regen,
        baseMana = base_mana,
        baseManaRegen = base_mana_regen,
        baseArmor = base_armor,
        baseMoveRate = base_mr,
        baseAttackMin = base_attack_min,
        baseAttackMax = base_attack_max,
        baseStr = base_str,
        baseAgi = base_agi,
        baseInt = base_int,
        strGain = str_gain,
        agiGain = agi_gain,
        intGain = int_gain,
        attackRange = attack_range,
        projectileSpeed = projectile_speed,
        attackRate = attack_rate,
        moveSpeed = move_speed,
        turnRate = turn_rate,
        legs = legs,
        turboPicks = turbo_picks,
        turboWins = turbo_wins,
        proWins = pro_win ?: 0,
        proPick = pro_pick ?: 0,
        firstPick = firstPick,
        firstWin = firstWin,
        secondPick = secondPick,
        secondWin = secondWin,
        thirdPick = thirdPick,
        thirdWin = thirdWin,
        fourthPick = fourthPick,
        fourthWin = fourthWin,
        fifthPick = fifthPick,
        fifthWin = fifthWin,
        sixthPick = sixthPick,
        sixthWin = sixthWin,
        seventhPick = seventhPick,
        seventhWin = seventhWin,
        eighthWin = eighthWin,
        eighthPick = eighthPick,
    )
}