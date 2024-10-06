package me.lukasabbe.sleepunderday.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public class SleepMixin {
    @ModifyExpressionValue(
            method = "tick",
            at= @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;isDay()Z",ordinal = 0)
    )
    public boolean shouldSleep(boolean original){
        return false;
    }
}
