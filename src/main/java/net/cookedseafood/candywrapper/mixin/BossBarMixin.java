package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.BossBarApi;
import net.minecraft.entity.boss.BossBar;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BossBar.class)
public abstract class BossBarMixin implements BossBarApi {
}
