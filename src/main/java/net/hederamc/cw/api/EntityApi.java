package net.hederamc.cw.api;

import net.minecraft.util.math.Vec3d;

public interface EntityApi {
    default double getXDelta() {
        return 0.0;
    }

    default double getYDelta() {
        return 0.0;
    }

    default double getZDelta() {
        return 0.0;
    }

    default Vec3d getPosDelta() {
        return null;
    }

    default float getYawDelta() {
        return 0.0f;
    }

    default float getPitchDelta() {
        return 0.0f;
    }

    default boolean hasCommandTag(String commandTag) {
        return false;
    }
}
