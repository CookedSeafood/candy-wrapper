package net.cookedseafood.candywrapper.mixin;

import java.util.Comparator;
import net.cookedseafood.candywrapper.api.LivingEntityApi;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.scoreboard.ScoreAccess;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableDouble;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityApi {
    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.fromName(((LivingEntity)(Object)this).getUuidAsString());
    }

    @Override
    public NbtCompound getCustomStatusEffect(String id, int amplifier) {
        NbtCompound statusEffect = new NbtCompound();
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        Identifier id2 = Identifier.of(id);
        int duration = scoreboard.getOrCreateScore(this.getScoreHolder(), scoreboard.getOrAddObjective("status_effect." + id2.getNamespace() + "." + id2.getPath() + "_" + amplifier, ScoreboardCriterion.DUMMY, Text.literal(StringUtils.capitalize(id2.getPath().replace('_', ' ')) + " " + amplifier), ScoreboardCriterion.RenderType.INTEGER, true, null)).getScore();
        if (duration == 0) {
            return statusEffect;
        }

        statusEffect.putString("id", id);
        statusEffect.putInt("duration", duration);
        statusEffect.putInt("amplifier", amplifier);
        return statusEffect;
    }

    @Override
    public NbtCompound getActiveCustomStatusEffect(String id) {
        NbtCompound activeStatusEffect = new NbtCompound();
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        ScoreHolder scoreHolder = this.getScoreHolder();
        Object[] activeStatusEffectObject = scoreboard.getObjectives()
            .stream()
            .filter(objective -> objective.getName().startsWith("status_effect."))
            .filter(objective -> objective.getName().contains(id.replace(':', '.')))
            .map(objective -> new Object[] {objective, scoreboard.getOrCreateScore(scoreHolder, objective).getScore()})
            .filter(object -> (int)object[1] != 0)
            .map(object -> new Object[] {object[0], object[1], ((ScoreboardObjective)object[0]).getName()})
            .map(object -> new Object[] {object[0], object[1], Integer.parseInt(((String)object[2]).substring(((String)object[2]).lastIndexOf('_') + 1))})
            .max(Comparator.comparingInt(object -> (int)object[2]))
            .orElse(null);
        if (activeStatusEffectObject == null) {
            return activeStatusEffect;
        }

        activeStatusEffect.putString("id", id);
        activeStatusEffect.putInt("duration", (int)activeStatusEffectObject[1]);
        activeStatusEffect.putInt("amplifier", (int)activeStatusEffectObject[2]);
        return activeStatusEffect;
    }

    @Override
    public NbtList getCustomStatusEffects(String id) {
        NbtList statusEffects = new NbtList();
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        ScoreHolder scoreHolder = this.getScoreHolder();
        scoreboard.getObjectives()
            .stream()
            .filter(objective -> objective.getName().startsWith("status_effect."))
            .filter(objective -> objective.getName().contains(id.replace(':', '.')))
            .map(objective -> new Object[] {objective, scoreboard.getOrCreateScore(scoreHolder, objective).getScore()})
            .filter(object -> (int)object[1] != 0)
            .forEach(object -> {
                ScoreboardObjective objective = (ScoreboardObjective)object[0];
                String name = objective.getName();
                NbtCompound statusEffect = new NbtCompound();
                statusEffect.putString("id", id);
                statusEffect.putInt("duration", (int)object[1]);
                statusEffect.putInt("amplifier", Integer.parseInt(name.substring(name.lastIndexOf('_') + 1)));
                statusEffects.add(statusEffect);
            });
        return statusEffects;
    }

    @Override
    public NbtList getCustomStatusEffects() {
        NbtList statusEffects = new NbtList();
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        ScoreHolder scoreHolder = this.getScoreHolder();
        scoreboard.getObjectives()
            .stream()
            .filter(objective -> objective.getName().startsWith("status_effect."))
            .map(objective -> new Object[] {objective, scoreboard.getOrCreateScore(scoreHolder, objective).getScore()})
            .filter(object -> (int)object[1] != 0)
            .forEach(object -> {
                ScoreboardObjective objective = (ScoreboardObjective)object[0];
                String name = objective.getName();
                int i = name.lastIndexOf('_');
                NbtCompound statusEffect = new NbtCompound();
                statusEffect.putString("id", name.substring(14, i).replace('.', ':'));
                statusEffect.putInt("duration", (int)object[1]);
                statusEffect.putInt("amplifier", Integer.parseInt(name.substring(i + 1)));
                statusEffects.add(statusEffect);
            });
        return statusEffects;
    }

    @Override
    public boolean hasCustomStatusEffect(String id, int amplifier) {
        return !this.getCustomStatusEffect(id, amplifier).isEmpty();
    }

    @Override
    public boolean hasCustomStatusEffect(String id) {
        return !this.getCustomStatusEffects(id).isEmpty();
    }
    
    @Override
    public boolean hasCustomStatusEffect() {
        return !this.getCustomStatusEffects().isEmpty();
    }

    @Override
    public boolean addCustomStatusEffect(String id) {
        return addCustomStatusEffect(id, 1);
    }

    @Override
    public boolean addCustomStatusEffect(String id, int duration) {
        return addCustomStatusEffect(id, duration, 0);
    }

    @Override
    public boolean addCustomStatusEffect(String id, int duration, int amplifier) {
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        Identifier id2 = Identifier.of(id);
        ScoreAccess durationScoreAccess = scoreboard.getOrCreateScore(this.getScoreHolder(), scoreboard.getOrAddObjective("status_effect." + id2.getNamespace() + "." + id2.getPath() + "_" + amplifier, ScoreboardCriterion.DUMMY, Text.literal(StringUtils.capitalize(id2.getPath().replace('_', ' ')) + " " + amplifier), ScoreboardCriterion.RenderType.INTEGER, true, null));
        if (durationScoreAccess.getScore() < duration) {
            durationScoreAccess.setScore(duration);
            return true;
        }

        return false;
    }

    @Override
    public void setCustomStatusEffect(String id) {
        this.setCustomStatusEffect(id, 1);
    }

    @Override
    public void setCustomStatusEffect(String id, int duration) {
        this.setCustomStatusEffect(id, duration, 0);
    }

    @Override
    public void setCustomStatusEffect(String id, int duration, int amplifier) {
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        Identifier id2 = Identifier.of(id);
        scoreboard.getOrCreateScore(this.getScoreHolder(), scoreboard.getOrAddObjective("status_effect." + id2.getNamespace() + "." + id2.getPath() + "_" + amplifier, ScoreboardCriterion.DUMMY, Text.literal(StringUtils.capitalize(id2.getPath().replace('_', ' ')) + " " + amplifier), ScoreboardCriterion.RenderType.INTEGER, true, null)).setScore(duration);
    }

    @Override
    public void removeCustomStatusEffect(String id, int amplifier) {
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        Identifier id2 = Identifier.of(id);
        scoreboard.getOrCreateScore(this.getScoreHolder(), scoreboard.getOrAddObjective("status_effect." + id2.getNamespace() + "." + id2.getPath() + "_" + amplifier, ScoreboardCriterion.DUMMY, Text.literal(StringUtils.capitalize(id2.getPath().replace('_', ' ')) + " " + amplifier), ScoreboardCriterion.RenderType.INTEGER, true, null)).resetScore();
    }

    @Override
    public void removeCustomStatusEffects(String id) {
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        scoreboard.getObjectives()
            .stream()
            .filter(objective -> objective.getName().startsWith("status_effect."))
            .filter(objective -> objective.getName().contains(id.replace(':', '.')))
            .forEach(objective -> scoreboard.getOrCreateScore(this.getScoreHolder(), objective).resetScore());
    }

    @Override
    public void removeCustomStatusEffects() {
        ServerScoreboard scoreboard = ((LivingEntity)(Object)this).getServer().getScoreboard();
        scoreboard.getObjectives()
            .stream()
            .filter(objective -> objective.getName().startsWith("status_effect."))
            .forEach(objective -> scoreboard.getOrCreateScore(this.getScoreHolder(), objective).resetScore());
    }

    @Override
    public double getCustomModifiedValue(String attribute, double base) {
        NbtList modifiers = this.getCustomModifiers(attribute);
        MutableDouble modified = new MutableDouble(base);

        modifiers.stream()
            .map(nbtElement -> (NbtCompound)nbtElement)
            .filter(modifier -> "add_value".equals(modifier.getString("operation")))
            .forEach(modifier -> modified.add(modifier.getDouble("base")));

        MutableDouble multiplier = new MutableDouble(1);

        modifiers.stream()
            .map(nbtElement -> (NbtCompound)nbtElement)
            .filter(modifier -> "add_multiplied_base".equals(modifier.getString("operation")))
            .forEach(modifier -> multiplier.add(modifier.getDouble("base")));

        modified.setValue(modified.getValue() * multiplier.getValue());

        modifiers.stream()
            .map(nbtElement -> (NbtCompound)nbtElement)
            .filter(modifier -> "add_multiplied_total".equals(modifier.getString("operation")))
            .forEach(modifier -> modified.setValue((1 + modifier.getDouble("base")) * modified.getValue()));

        return modified.getValue();
    }

    @Override
    public NbtList getCustomModifiers(String attribute) {
        NbtList modifiers = new NbtList();
        this.getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> attribute.equals(modifier.getString("attribute"))).forEach(modifier -> modifiers.add(modifier));
        return modifiers;
    }

    @Override
    public NbtList getCustomModifiers() {
        NbtList modifiers = new NbtList();
        this.getEquippedStack(EquipmentSlot.MAINHAND)   .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "mainhand" .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        this.getEquippedStack(EquipmentSlot.OFFHAND)    .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "offhand"  .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        this.getEquippedStack(EquipmentSlot.FEET)       .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "feet"     .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        this.getEquippedStack(EquipmentSlot.LEGS)       .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "legs"     .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        this.getEquippedStack(EquipmentSlot.CHEST)      .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "chest"    .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        this.getEquippedStack(EquipmentSlot.HEAD)       .getCustomModifiers().stream().map(nbtElement -> (NbtCompound)nbtElement).filter(modifier -> "head"     .equals(modifier.getString("slot"))).forEach(modifier -> modifiers.add(modifier));
        return modifiers;
    }

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);
}
