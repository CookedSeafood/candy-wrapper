package net.cookedseafood.candywrapper.api;

import net.minecraft.util.Identifier;

public interface RegistryEntryApi {
    default Identifier getId() {
        return null;
    }
}
