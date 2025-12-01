package net.hederamc.cw.mixin;

import net.hederamc.cw.api.ItemStackApi;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ItemStackApi {
    @Override
    public Identifier getId() {
        return this.getRegistryEntry().getKey().map(key -> key.getValue()).orElse(Identifier.ofVanilla("unregistered"));
    }

    @Override
    public String getIdAsString() {
        return this.getRegistryEntry().getIdAsString();
    }

    @Shadow
    public abstract RegistryEntry<Item> getRegistryEntry();
}
