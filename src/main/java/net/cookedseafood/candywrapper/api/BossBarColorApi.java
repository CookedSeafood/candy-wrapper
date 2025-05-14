package net.cookedseafood.candywrapper.api;

import net.minecraft.util.Formatting;

public interface BossBarColorApi {
    default Formatting getFormat() {
        return null;
    }
}
