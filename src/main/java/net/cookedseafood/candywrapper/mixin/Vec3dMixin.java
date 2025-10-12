package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.Vec3dApi;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vec3d.class)
public abstract class Vec3dMixin implements Vec3dApi {
    /**
     * Creates a vector representing the bottom center of the given block
     * position.
     * 
     * <p>The bottom center of a block position {@code pos} is
     * {@code (pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5)}.
     * 
     * @see #ofCenter(Vec3i)
     */
    @Override
    public Vec3d ofTopCenter(Vec3i vec) {
        return add(vec, 0.5, 1.0, 0.5);
    }

    @Shadow
    public abstract Vec3d add(Vec3i vec, double deltaX, double deltaY, double deltaZ);

    @Shadow
    public abstract Vec3d ofCenter(Vec3i vec);
}
