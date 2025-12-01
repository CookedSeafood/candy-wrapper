package net.hederamc.cw.mixin;

import java.util.Optional;
import net.hederamc.cw.api.RegistryEntryApi;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RegistryEntry.class)
public abstract class RegistryEntryMixin implements RegistryEntryApi {
    @Override
    public Identifier getId() {
        return this.getKey().map(key -> key.getValue()).orElse(Identifier.ofVanilla("unregistered"));
    }

    @Shadow
    abstract Optional<RegistryKey<?>> getKey();
}
