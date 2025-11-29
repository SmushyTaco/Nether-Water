package com.smushytaco.nether_water.mixin;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.smushytaco.nether_water.NetherWater;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(BucketItem.class)
public abstract class WaterTweaks {
    @WrapOperation(method = "emptyContents", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/dimension/DimensionType;ultraWarm()Z"))
    private boolean hookPlaceFluid(DimensionType instance, Operation<Boolean> original, @Nullable LivingEntity user, Level world, BlockPos pos, @Nullable BlockHitResult hitResult) { return original.call(instance) && !NetherWater.INSTANCE.canHaveWater(pos.getY()); }
}