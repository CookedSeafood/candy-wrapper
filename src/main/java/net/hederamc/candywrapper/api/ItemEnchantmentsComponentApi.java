package net.hederamc.candywrapper.api;

public interface ItemEnchantmentsComponentApi {
    default int getLevel(String enchantment) {
        return 0;
    }
}
