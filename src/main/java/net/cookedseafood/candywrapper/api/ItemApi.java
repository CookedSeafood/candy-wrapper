package net.cookedseafood.candywrapper.api;

import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;

public interface ItemApi {
    default boolean isIn(TagKey<Item> tag) {
        return false;
    }

    default boolean isIn(RegistryEntryList<Item> registryEntryList) {
        return false;
    }
}
