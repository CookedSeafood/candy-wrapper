package net.hederamc.cw.mixin;

import net.hederamc.cw.api.BossBarColorApi;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BossBar.Color.class)
public abstract class BossBarColorMixin implements BossBarColorApi {
    @Shadow
    private Formatting format;

    @Override
    public Formatting getFormat() {
        return format;
    }
}
