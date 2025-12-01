package net.hederamc.cw.mixin;

import java.util.Map;
import java.util.Set;
import net.hederamc.cw.api.NbtCompoundApi;
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
    public Set<String> keySet() {
        return this.entries.keySet();
    }

    @Override
    public void putAll(NbtCompound nbtCompound) {
        this.entries.putAll(nbtCompound.getEntries());
    }
}
