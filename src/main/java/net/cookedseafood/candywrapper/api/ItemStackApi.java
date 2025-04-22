package net.cookedseafood.candywrapper.api;

import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;

public interface ItemStackApi {
	default Identifier getId() {
		return null;
	}

	default String getIdAsString() {
		return null;
	}

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
