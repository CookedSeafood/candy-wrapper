package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.LivingEntityApi;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.scoreboard.ScoreHolder;
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

        return modified.doubleValue();
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
