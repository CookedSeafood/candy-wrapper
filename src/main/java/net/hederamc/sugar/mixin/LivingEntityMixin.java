package net.hederamc.sugar.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayList;
import java.util.List;
import net.hederamc.sugar.api.LivingEntityApi;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityApi {
    @Shadow private boolean dead;
    @Shadow private float lastBodyYaw;
    @Shadow private float lastHeadYaw;
    @Shadow private float bodyYaw;
    @Shadow private float headYaw;

    @Override
    public List<Entry<RegistryEntry<Enchantment>>> getEnchantments(RegistryKey<Enchantment> key) {
        List<Entry<RegistryEntry<Enchantment>>> enchantments = new ArrayList<>();
        this.getEnchantments().stream().filter(entry -> entry.getKey().matchesKey(key)).forEach(entry -> enchantments.add(entry));
        return enchantments;
    }

    @Override
    public List<Entry<RegistryEntry<Enchantment>>> getEnchantments() {
        List<Entry<RegistryEntry<Enchantment>>> enchantments = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = this.getEquippedStack(slot);
            if (stack.isEmpty()) {
                continue;
            }

            ItemEnchantmentsComponent component = stack.getEnchantments();
            if (component.isEmpty()) {
                continue;
            }

            component.getEnchantmentEntries().stream().filter(entry -> entry.getKey().value().slotMatches(slot)).forEach(entry -> enchantments.add(entry));
        }

        return enchantments;
    }

    @Override
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public float getLerpedBodyYaw(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastBodyYaw, this.bodyYaw);
    }

    @Override
    public float getLerpedHeadYaw(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastHeadYaw, this.headYaw);
    }

    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.fromName(((LivingEntity)(Object)this).getUuidAsString());
    }

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);
}
