package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtList;

public interface ItemStackApi {
	default String getCustomId() {
		return null;
	}

	default NbtList getCustomModifiers() {
		return null;
	}

	default NbtList getCustomStatusEffects() {
		return null;
	}
}
