package net.cookedseafood.candywrapper.api;

import net.minecraft.scoreboard.ScoreHolder;

public interface LivingEntityApi {
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
