package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtList;
import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
    default ScoreHolder getScoreHolder() {
		return ScoreHolder.WILDCARD;
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
