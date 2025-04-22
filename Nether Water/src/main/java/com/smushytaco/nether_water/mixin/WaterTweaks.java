package com.smushytaco.nether_water.mixin;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.smushytaco.nether_water.NetherWater;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(BucketItem.class)
public abstract class WaterTweaks {
    @WrapOperation(method = "placeFluid", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/dimension/DimensionType;ultrawarm()Z"))
    private boolean hookPlaceFluid(DimensionType instance, Operation<Boolean> original, @Nullable LivingEntity user, World world, BlockPos pos, @Nullable BlockHitResult hitResult) { return original.call(instance) && !NetherWater.INSTANCE.canHaveWater(pos.getY()); }
}