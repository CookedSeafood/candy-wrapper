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

    public boolean containsKey(Identifier id) {}

    public void remove(Identifier id) {}
}
```

```java
public abstract class BossBar {
    public static enum Color {
        public Formatting getFormat() {}
    }
}
```

```java
public class NbtCompound {
    public Map<? extends String, ? extends NbtElement> getEntries() {}

    public Set<String> keySet() {}

    public void putAll(NbtCompound entries) {}
}
```

```java
public class NbtComponent {
    public NbtComponent copyFrom(NbtComponent nbtComponent) {}
}
```

```java
public final class ItemStack {
    public Identifier getId() {}

    // A shortcut of .getRegistryEntry().getIdAsString()
    public String getIdAsString() {}
}
```

```java
public abstract class PlayerEntity {
    public ScoreHolder getScoreHolder() {}
}
```

```java
public abstract class LivingEntity {
    public void setDead(boolean dead) {}

    public float getBodyYawDelta() {}

    public float getHeadYawDelta() {}

    public ScoreHolder getScoreHolder() {}
}
```

```java
public abstract class BossBars {
    public abstract class Colors {
        public static String getName(Formatting format) {}

        public static Formatting getFormat(String name) {}

        public static BossBar.Color byName(String name) {}

        public static BossBar.Color byFormat(Formatting format) {}
    }

    public abstract class Styles {
        public static BossBar.Style byName(String name) {}
    }
}
```

## FAQ

### Performence downside if only install the library?

No. Except that it takes a few more milliseconds to start Minecraft.
