package net.cookedseafood.candywrapper.mixin;

import net.cookedseafood.candywrapper.api.ItemStackApi;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ItemStackApi {
	@Override
	public NbtList getCustomModifiers() {
		return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getList("modifiers", NbtElement.COMPOUND_TYPE);
	}

	@Override
	public NbtList getCustomStatusEffects() {
		return ((ItemStack)(Object)this).getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt().getList("status_effects", NbtElement.COMPOUND_TYPE);
	}
}
