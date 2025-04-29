package net.cookedseafood.candywrapper.api;

import java.util.Map;
import net.minecraft.nbt.NbtElement;

public interface NbtCompoundApi {
    default void putAll(Map<? extends String, ? extends NbtElement> m) {
    }
}
