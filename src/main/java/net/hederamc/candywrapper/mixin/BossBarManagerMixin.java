package net.hederamc.candywrapper.mixin;

import java.util.Map;
import net.hederamc.candywrapper.api.BossBarManagerApi;
import net.minecraft.entity.boss.BossBarManager;
import net.minecraft.entity.boss.CommandBossBar;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BossBarManager.class)
public abstract class BossBarManagerMixin implements BossBarManagerApi {
    @Shadow
    private Map<Identifier, CommandBossBar> commandBossBars;

    @Override
    public CommandBossBar getOrAdd(Identifier id, Text displayName) {
        CommandBossBar commandBossBar = this.get(id);
        if (commandBossBar == null) {
            commandBossBar = this.add(id, displayName);
        }

        return commandBossBar;
    }

    @Override
    public boolean containsKey(Identifier id) {
        return this.commandBossBars.containsKey(id);
    }

    @Override
    public void remove(Identifier id) {
        this.commandBossBars.remove(id);
    }

    @Shadow
    public abstract CommandBossBar get(Identifier id);

    @Shadow
    public abstract CommandBossBar add(Identifier id, Text displayName);
}
