package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtList;
import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
    default ScoreHolder getScoreHolder() {
		return null;
	}

    default double getCustomModifiedValue(String attribute, double base) {
        return 0.0d;
    }

    default NbtList getCustomModifiers(String attribute) {
        return null;
    }

    default NbtList getCustomModifiers() {
        return null;
    }
}
