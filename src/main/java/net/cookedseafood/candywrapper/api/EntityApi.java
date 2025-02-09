package net.cookedseafood.candywrapper.api;

public interface EntityApi {
    default boolean hasCommandTag(String commandTag) {
        return false;
    }
}
