package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.LivingEntityApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.scoreboard.ScoreHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityApi {
    @Shadow
    public float bodyYaw;
    @Shadow
    public float lastBodyYaw;
    @Shadow
    public float headYaw;
    @Shadow
    public float lastHeadYaw;

    @Override
    public float getBodyYawDelta() {
        return this.bodyYaw - this.lastBodyYaw;
    }

    @Override
    public float getHeadYawDelta() {
        return this.headYaw - this.lastHeadYaw;
    }

    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.fromName(((LivingEntity)(Object)this).getUuidAsString());
    }
}
