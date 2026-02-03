package com.smushytaco.nether_water.mixin;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.smushytaco.nether_water.NetherWater;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(BucketItem.class)
public abstract class WaterTweaks {
    @ModifyExpressionValue(method = "emptyContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/Fluid;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean hookPlaceFluid(boolean original, @Nullable LivingEntity livingEntity, Level level, BlockPos blockPos, @Nullable BlockHitResult blockHitResult) { return original && !NetherWater.INSTANCE.canHaveWater(blockPos.getY()); }
}