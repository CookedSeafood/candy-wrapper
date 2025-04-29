package net.cookedseafood.candywrapper.api;

import java.util.Map;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface NbtCompoundApi {
    default Map<? extends String, ? extends NbtElement> getEntries() {
        return null;
    }

    default void putAll(NbtCompound entries) {
    }
}
