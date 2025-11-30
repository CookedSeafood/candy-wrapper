package net.hederamc.candywrapper.api;

import net.minecraft.component.type.NbtComponent;

public interface NbtComponentApi {
    default NbtComponent copyFrom(NbtComponent nbtComponent) {
        return null;
    }
}
