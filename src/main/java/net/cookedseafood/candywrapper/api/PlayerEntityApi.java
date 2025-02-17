package net.cookedseafood.candywrapper.api;

import net.minecraft.scoreboard.ScoreHolder;

public interface PlayerEntityApi {
	default ScoreHolder getScoreHolder() {
		return ScoreHolder.WILDCARD;
	}
}
