package net.cookedseafood.candywrapper.api;

import net.minecraft.scoreboard.ScoreHolder;

public interface ServerPlayerEntityApi {
	default ScoreHolder getScoreHolder() {
		return ScoreHolder.WILDCARD;
	}
}
