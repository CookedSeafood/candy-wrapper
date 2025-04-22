package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.ItemStackApi;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ItemStackApi {
	@Override
	public Identifier getId() {
		return this.getRegistryEntry().getId();
	}

	@Override
	public String getIdAsString() {
		return this.getRegistryEntry().getIdAsString();
	}

	@Override
	public String getCustomId() {
		return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getString("id");
	}

	@Override
	public NbtList getCustomModifiers() {
		return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getList("modifiers", NbtElement.COMPOUND_TYPE);
	}

	@Override
	public NbtList getCustomStatusEffects() {
		return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getList("status_effects", NbtElement.COMPOUND_TYPE);
	}

	@Shadow
	public abstract RegistryEntry<Item> getRegistryEntry();
}
