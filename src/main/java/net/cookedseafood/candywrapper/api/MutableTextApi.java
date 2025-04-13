package net.cookedseafood.candywrapper.api;

import net.minecraft.text.Text;

public interface MutableTextApi {
	/**
	 * Copies the text's content, the style, and the siblings.
	 * 
	 * <p>A deep copy.
	 */
	default Text deepCopy() {
		return null;
	}
}
