package me.lukasabbe.sleepunderday.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerPlayer.class)
public class StartSleepingMixinFabric {
    @ModifyExpressionValue(
            method = "startSleepInBed",
            at= @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;isDay()Z")
    )
    public boolean sleepCheck(boolean original){
        return false;
    }
}
