package net.cookedseafood.candywrapper.api;

import java.util.Map;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public interface NbtCompoundApi {
    default NbtCompound of(Map<String, NbtElement> entries) {
        return null;
    }
}
