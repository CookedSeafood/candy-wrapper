package net.hederamc.cw.mixin;

import java.util.Optional;
import java.util.Set;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.entry.RegistryEntry;
import net.hederamc.cw.api.ItemEnchantmentsComponentApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemEnchantmentsComponent.class)
public abstract class ItemEnchantmentsComponentMixin implements ItemEnchantmentsComponentApi {
    @Override
    public int getLevel(String enchantment) {
        Optional<RegistryEntry<Enchantment>> matchedEnchantment = this.getEnchantments()
            .stream()
            .filter(presentedEnchantment -> presentedEnchantment.getIdAsString().equals(enchantment))
            .findAny();
        return matchedEnchantment.isPresent() ? this.getLevel(matchedEnchantment.get()) : 0;
    }

    @Shadow
    public abstract Set<RegistryEntry<Enchantment>> getEnchantments();

    @Shadow
    public abstract int getLevel(RegistryEntry<Enchantment> enchantment);
}
