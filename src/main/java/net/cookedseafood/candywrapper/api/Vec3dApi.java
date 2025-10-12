package net.cookedseafood.candywrapper.api;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public interface Vec3dApi {
    default Vec3d ofTopCenter(Vec3i vec) {
        return null;
    }
}
