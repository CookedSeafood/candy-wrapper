package net.hederamc.cw.api;

public interface EntityApi {
    default double getLerpedX(float tickProgress) {
        return 0.0;
    }

    default double getLerpedY(float tickProgress) {
        return 0.0;
    }

    default double getLerpedZ(float tickProgress) {
        return 0.0;
    }

    default boolean hasCommandTag(String commandTag) {
        return false;
    }
}
