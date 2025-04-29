package net.cookedseafood.candywrapper.mixin;

import java.util.Map;
import net.cookedseafood.candywrapper.api.NbtCompoundApi;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NbtCompound.class)
public abstract class NbtCompoundMixin implements NbtCompoundApi {
    @Shadow
    private Map<String, NbtElement> entries;

    @Override
    public void putAll(Map<? extends String, ? extends NbtElement> entries) {
        this.entries.putAll(entries);
    }
}
