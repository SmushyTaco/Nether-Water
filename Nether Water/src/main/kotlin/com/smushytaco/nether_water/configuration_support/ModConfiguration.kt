package com.smushytaco.nether_water.configuration_support
import com.smushytaco.nether_water.NetherWater
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
@Config(name = NetherWater.MOD_ID)
class ModConfiguration: ConfigData {
    val enableNetherWater = true
    val allowWaterEverywhere = true
    var maximumWaterHeight = 255
    var minimumWaterHeight = 0
}