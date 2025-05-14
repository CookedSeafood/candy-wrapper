package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.ItemStackApi;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
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

    @Override
    public String getCustomIdOrId() {
        String customId = this.getCustomId();
        return customId == "" ? this.getIdAsString() : customId;
    }

    @Override
    public String getCustomId() {
        return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getString("id", "");
    }

    @Override
    public NbtList getCustomModifiers() {
        return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getListOrEmpty("modifiers");
    }

    @Override
    public NbtList getCustomStatusEffects() {
        return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getListOrEmpty("status_effects");
    }

    @Shadow
    public abstract RegistryEntry<Item> getRegistryEntry();
}
