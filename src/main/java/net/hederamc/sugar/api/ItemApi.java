package net.hederamc.sugar.api;

import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public interface ItemApi {
    default Identifier getId() {
        return null;
    }

    default String getIdAsString() {
        return null;
    }

    default boolean isIn(TagKey<Item> tag) {
        return false;
    }

    default boolean isIn(RegistryEntryList<Item> registryEntryList) {
        return false;
    }
}
