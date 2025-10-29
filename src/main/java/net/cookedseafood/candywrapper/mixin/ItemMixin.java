package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.ItemApi;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public abstract class ItemMixin implements ItemApi {
    @Override
    public boolean isIn(TagKey<Item> tag) {
        return this.getRegistryEntry().isIn(tag);
    }

    @Override
    public boolean isIn(RegistryEntryList<Item> registryEntryList) {
        return registryEntryList.contains(this.getRegistryEntry());
    }

    @Shadow
    public abstract RegistryEntry.Reference<Item> getRegistryEntry();
}
