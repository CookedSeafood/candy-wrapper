package net.cookedseafood.candywrapper.mixin;

import java.util.Map;
import net.cookedseafood.candywrapper.api.NbtCompoundApi;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NbtCompound.class)
public class NbtCompoundMixin implements NbtCompoundApi {
    @Override
    public NbtCompound of(Map<String, NbtElement> entries) {
        return new NbtCompound(entries);
    }
}
