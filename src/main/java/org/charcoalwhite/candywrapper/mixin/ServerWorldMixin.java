package org.charcoalwhite.candywrapper.mixin;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;
import org.charcoalwhite.candywrapper.api.ServerWorldApi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin implements ServerWorldApi {
    @Override
    public <T extends Entity> List<? extends T> getEntitiesByClass(Class<T> entityClass, Predicate<? super T> predicate) {
        return this.getEntitiesByType(TypeFilter.instanceOf(entityClass), predicate);
    }

    @Shadow
    public abstract <T extends Entity> List<? extends T> getEntitiesByType(TypeFilter<Entity, T> filter, Predicate<? super T> predicate);
}
