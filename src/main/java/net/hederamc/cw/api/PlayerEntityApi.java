package net.hederamc.cw.api;

import net.minecraft.scoreboard.ScoreHolder;

public interface PlayerEntityApi {
    default ScoreHolder getScoreHolder() {
        return null;
    }
}
