package net.hederamc.candywrapper.mixin;

import com.mojang.authlib.GameProfile;
import net.hederamc.candywrapper.api.PlayerEntityApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements PlayerEntityApi {
    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.fromProfile(this.getGameProfile());
    }

    @Shadow
    public abstract GameProfile getGameProfile();
}
