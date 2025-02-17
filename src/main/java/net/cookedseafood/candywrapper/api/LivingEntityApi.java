package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
    default ScoreHolder getScoreHolder() {
		return ScoreHolder.WILDCARD;
	}

    default NbtCompound getCustomStatusEffect(String id, int amplifier) {
        return new NbtCompound();
    }

    default NbtCompound getActiveCustomStatusEffect(String id) {
        return new NbtCompound();
    }

    default NbtList getCustomStatusEffects(String id) {
        return new NbtList();
    }

    default NbtList getCustomStatusEffects() {
        return new NbtList();
    }

    default boolean hasCustomStatusEffect(String id, int amplifier) {
        return false;
    }

    default boolean hasCustomStatusEffect(String id) {
        return false;
    }

    default boolean hasCustomStatusEffect() {
        return false;
    }

    default boolean addCustomStatusEffect(String id) {
        return false;
    }

    default boolean addCustomStatusEffect(String id, int duration) {
        return false;
    }

    default boolean addCustomStatusEffect(String id, int duration, int amplifier) {
        return false;
    }

    default void setCustomStatusEffect(String id) {
    }

    default void setCustomStatusEffect(String id, int duration) {
    }

    default void setCustomStatusEffect(String id, int duration, int amplifier) {
    }

    default void removeCustomStatusEffect(String id, int amplifier) {
    }

    default void removeCustomStatusEffects(String id) {
    }

    default void removeCustomStatusEffects() {
    }

    default double getCustomModifiedValue(String attribute, double base) {
        return 0;
    }

    default NbtList getCustomModifiers(String attribute) {
        return new NbtList();
    }

    default NbtList getCustomModifiers() {
        return new NbtList();
    }
}
