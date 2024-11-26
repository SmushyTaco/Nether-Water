package com.smushytaco.nether_water
import net.fabricmc.api.ModInitializer
object NetherWater : ModInitializer {
    const val MOD_ID = "nether_water"
    private val config = ModConfig.createAndLoad()
    override fun onInitialize() {}
    fun canHaveWater(y: Int): Boolean {
        if (!config.enableNetherWater) return false
        if (config.allowWaterEverywhere) return true
        if (config.maximumWaterHeight < config.minimumWaterHeight) {
            config.minimumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            config.maximumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            config.minimumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            config.save()
        }
        if (y in config.minimumWaterHeight .. config.maximumWaterHeight) return true
        return false
    }
}