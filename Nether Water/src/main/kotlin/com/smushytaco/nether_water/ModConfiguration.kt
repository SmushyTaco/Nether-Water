package com.smushytaco.nether_water
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = NetherWater.MOD_ID)
@Config(name = NetherWater.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var enableNetherWater = true
    @JvmField
    var allowWaterEverywhere = true
    @JvmField
    var maximumWaterHeight = 255
    @JvmField
    var minimumWaterHeight = 0
}