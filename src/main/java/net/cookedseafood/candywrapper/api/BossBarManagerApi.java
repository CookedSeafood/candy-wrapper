package net.cookedseafood.candywrapper.api;

import net.minecraft.util.Identifier;

public interface BossBarManagerApi {
    default boolean contains(Identifier id) {
        return false;
    }

    default void remove(Identifier id) {
    }
}
