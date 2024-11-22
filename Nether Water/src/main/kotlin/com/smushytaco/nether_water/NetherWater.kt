package com.smushytaco.nether_water
import com.smushytaco.nether_water.configuration_support.ModConfiguration
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.ConfigHolder
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer
import net.fabricmc.api.ModInitializer
object NetherWater : ModInitializer {
    const val MOD_ID = "nether_water"
    private lateinit var configHolder: ConfigHolder<ModConfiguration>
    private lateinit var config: ModConfiguration
    override fun onInitialize() {
        AutoConfig.register(ModConfiguration::class.java) { definition: Config, configClass: Class<ModConfiguration> ->
            GsonConfigSerializer(definition, configClass)
        }
        configHolder = AutoConfig.getConfigHolder(ModConfiguration::class.java)
        config = configHolder.config
    }
    fun canHaveWater(y: Int): Boolean {
        if (!config.enableNetherWater) return false
        if (config.allowWaterEverywhere) return true
        if (config.maximumWaterHeight < config.minimumWaterHeight) {
            config.minimumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            config.maximumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            config.minimumWaterHeight = config.minimumWaterHeight xor config.maximumWaterHeight
            configHolder.save()
        }
        if (y in config.minimumWaterHeight .. config.maximumWaterHeight) return true
        return false
    }
}