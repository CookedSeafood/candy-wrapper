package net.cookedseafood.candywrapper.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface NbtCompoundApi {
    default Map<? extends String, ? extends NbtElement> getEntries() {
        return null;
    }

    default Set<String> keySet() {
        return null;
    }

    default Collection<NbtElement> values() {
        return null;
    }

    default void putAll(NbtCompound entries) {
    }
}
