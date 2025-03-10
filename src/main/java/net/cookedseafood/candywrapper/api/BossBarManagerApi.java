package net.cookedseafood.candywrapper.api;

import net.minecraft.entity.boss.CommandBossBar;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface BossBarManagerApi {
    default CommandBossBar getOrAdd(Identifier id, Text displayName) {
        return new CommandBossBar(id, displayName);
    }

    default boolean contains(Identifier id) {
        return false;
    }

    default void remove(Identifier id) {
    }
}
