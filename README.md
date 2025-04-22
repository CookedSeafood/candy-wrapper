# Candy Wrapper

Candy Warpper is a library mod I use in many of my mods. You are free to use it in your mods.

Things made player riding possible:

- Redirect `isSaveable()` in `addPassenger()` to a custom method which returns `isPlayer()` if not saveable.
- Send `EntityPassengersSetS2CPacket` to the vehicle player when mounting or dismounting.

Other utils:

```java
public class ItemEnchantmentsComponent {
    public int getLevel(String enchantment) {}
}
```

```java
public class Scoreboard {
    public ScoreboardObjective getOrAddObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat) {}

    public Team getOrAddTeam(String name) {}
}
```

```java
public abstract class Entity {
    public double getXDelta() {}

    public double getYDelta() {}

    public double getZDelta() {}

    public double getPosDelta() {}

    public double getYawDelta() {}

    public double getPitchDelta() {}

    // A shortcut of .getCommandTags().contains(commandTag)
    public boolean hasCommandTag(String commandTag) {}
}
```

```java
public class BossBarManager {
    public CommandBossBar getOrAdd(Identifier id, Text displayName) {}

    public boolean contains(Identifier id) {}

    public void remove(Identifier id) {}
}
```

```java
public interface RegistryEntry<T> {
    public Identifier getId() {}
}
```

```java
public final class ItemStack {
    // A shortcut of .getRegistryEntry().getId()
    public Identifier getId() {}

    // A shortcut of .getRegistryEntry().getIdAsString()
    public String getIdAsString() {}

    // From `id` in `minecraft:custom_data`.
    public NbtList getCustomId() {}

    // From `modifiers` in `minecraft:custom_data`.
    public NbtList getCustomModifiers() {}

    // From `status_effects` in `minecraft:custom_data`.
    public NbtList getCustomStatusEffects() {}
}
```

```java
public abstract class PlayerEntity {
    public ScoreHolder getScoreHolder() {}
}
```

```java
public abstract class LivingEntity {
    public float getBodyYawDelta() {}

    public float getHeadYawDelta() {}

    public ScoreHolder getScoreHolder() {}

    public double getCustomModifiedValue(String attribute, double base) {}

    // From equipped `ItemStack`s, filtered based on `attribute` field.
    public NbtList getCustomModifiers(String attribute) {}

    // From equipped `ItemStack`s.
    public NbtList getCustomModifiers() {}
}
```

## FAQ

### Performence downside if only install the library?

No. Except that it takes a few more milliseconds to start Minecraft.
