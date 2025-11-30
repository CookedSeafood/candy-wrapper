package net.hederamc.candywrapper.api;

import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
    default List<RegistryEntry<Enchantment>> getEnchantments() {
        return null;
    }

    default void setDead(boolean dead) {
    }

    default float getBodyYawDelta() {
        return 0.0f;
    }

    default float getHeadYawDelta() {
        return 0.0f;
    }

    default ScoreHolder getScoreHolder() {
        return null;
    }
}
