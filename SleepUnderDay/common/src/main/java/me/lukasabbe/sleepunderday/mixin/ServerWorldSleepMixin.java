package me.lukasabbe.sleepunderday.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerLevel.class)
public class ServerWorldSleepMixin {
    @WrapWithCondition(
            method = "tick",
            at= @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setDayTime(J)V")
    )
    public boolean wrapTimeSet(ServerLevel instance, long pTime){
        return !instance.isDay();
    }
}
