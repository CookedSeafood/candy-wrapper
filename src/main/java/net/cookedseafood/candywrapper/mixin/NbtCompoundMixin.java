package net.cookedseafood.candywrapper.mixin;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
    public Map<? extends String, ? extends NbtElement> getEntries() {
        return this.entries;
    }

    @Override
    public Set<Entry<String, NbtElement>> entrySet() {
        return this.entries.entrySet();
    }

    @Override
    public Set<String> keySet() {
        return this.entries.keySet();
    }

    @Override
    public Collection<NbtElement> values() {
        return this.entries.values();
    }

    @Override
    public void putAll(NbtCompound nbtCompound) {
        this.entries.putAll(nbtCompound.getEntries());
    }
}
