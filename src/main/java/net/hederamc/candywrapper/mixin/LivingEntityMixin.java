package net.hederamc.candywrapper.mixin;

import java.util.ArrayList;
import java.util.List;
import net.hederamc.candywrapper.api.LivingEntityApi;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.ScoreHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityApi {
    @Shadow
    public boolean dead;
    @Shadow
    public float bodyYaw;
    @Shadow
    public float lastBodyYaw;
    @Shadow
    public float headYaw;
    @Shadow
    public float lastHeadYaw;

    @Override
    public List<RegistryEntry<Enchantment>> getEnchantments() {
        List<RegistryEntry<Enchantment>> enchantments = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = this.getEquippedStack(slot);
            if (stack.isEmpty()) {
                continue;
            }

            ItemEnchantmentsComponent component = stack.getEnchantments();
            if (component.isEmpty()) {
                continue;
            }

            for (RegistryEntry<Enchantment> registryEntry : component.getEnchantments()) {
                if (registryEntry.value().slotMatches(slot)) {
                    enchantments.add(registryEntry);
                }
            }
        }

        return enchantments;
    }

    @Override
    public void setDead(boolean dead) {
        this.dead = dead;
    }

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

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);
}
