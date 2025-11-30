package net.hederamc.candywrapper.api;

import net.minecraft.util.Identifier;

public interface ItemStackApi {
    default Identifier getId() {
        return null;
    }

    default String getIdAsString() {
        return null;
    }
}
