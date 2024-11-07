package org.charcoalwhite.candywrapper.api;

public interface EntityApi {
    default boolean hasCommandTag(String commandTag) {
        return false;
    }
}
