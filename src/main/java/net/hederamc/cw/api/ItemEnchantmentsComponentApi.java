package net.hederamc.cw.api;

public interface ItemEnchantmentsComponentApi {
    default int getLevel(String enchantment) {
        return 0;
    }
}
