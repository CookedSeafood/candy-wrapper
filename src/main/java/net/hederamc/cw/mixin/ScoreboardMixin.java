package net.hederamc.cw.mixin;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.number.NumberFormat;
import net.minecraft.text.Text;
import net.hederamc.cw.api.ScoreboardApi;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Scoreboard.class)
public abstract class ScoreboardMixin implements ScoreboardApi {
    @Override
    public ScoreboardObjective getOrAddObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {
        ScoreboardObjective objective = this.getNullableObjective(name);
        if (objective == null) {
            objective = this.addObjective(name, criterion, displayName, renderType, displayAutoUpdate, numberFormat);
        }

        return objective;
    }

    @Override
    public Team getOrAddTeam(String name) {
        Team team = this.getTeam(name);
        if (team == null) {
            team = this.addTeam(name);
        }

        return team;
    }

    @Shadow
    @Nullable
    public abstract ScoreboardObjective getNullableObjective(@Nullable String name);

    @Shadow
    public abstract ScoreboardObjective addObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat);

    @Shadow
    @Nullable
    public abstract Team getTeam(String name);

    @Shadow
    public abstract Team addTeam(String name);
}
