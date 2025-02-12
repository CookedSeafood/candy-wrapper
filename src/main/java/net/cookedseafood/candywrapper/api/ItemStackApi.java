package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtList;

public interface ItemStackApi {
    default NbtList getCustomModifiers() {
        return new NbtList();
    }
}
