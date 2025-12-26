package net.hederamc.sugar.api;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
    default List<Entry<RegistryEntry<Enchantment>>> getEnchantments(RegistryKey<Enchantment> key) {
        return null;
    }

    default List<Entry<RegistryEntry<Enchantment>>> getEnchantments() {
        return null;
    }

    default void setDead(boolean dead) {
    }

    default float getLerpedBodyYaw(float tickProgress) {
        return 0.0f;
    }

    default float getLerpedHeadYaw(float tickProgress) {
        return 0.0f;
    }

    default ScoreHolder getScoreHolder() {
        return null;
    }
}
