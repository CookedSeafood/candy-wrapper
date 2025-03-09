package net.cookedseafood.candywrapper.mixin;

import java.util.Map;
import net.cookedseafood.candywrapper.api.BossBarManagerApi;
import net.minecraft.entity.boss.BossBarManager;
import net.minecraft.entity.boss.CommandBossBar;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BossBarManager.class)
public abstract class BossBarManagerMixin implements BossBarManagerApi {
    @Shadow
    private Map<Identifier, CommandBossBar> commandBossBars;

    @Override
    public boolean contains(Identifier id) {
        return commandBossBars.containsKey(id);
    }

    @Override
    public void remove(Identifier id) {
        commandBossBars.remove(id);
    }
}
