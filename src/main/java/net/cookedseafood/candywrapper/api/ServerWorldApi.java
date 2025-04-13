package net.cookedseafood.candywrapper.api;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;

public interface ServerWorldApi {
	default <T extends Entity> List<? extends T> getEntitiesByClass(Class<T> entityClass, Predicate<? super T> predicate) {
		return null;
	}
}
