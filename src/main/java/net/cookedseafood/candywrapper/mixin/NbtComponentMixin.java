package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.NbtComponentApi;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NbtComponent.class)
public abstract class NbtComponentMixin implements NbtComponentApi {
    @Override
    public NbtComponent copyFrom(NbtComponent nbtComponent) {
        return NbtComponent.of(this.getNbt().copyFrom(nbtComponent.copyNbt()));
    }

    @Shadow
    public abstract NbtCompound getNbt();
}
