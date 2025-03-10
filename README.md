# Candy Wrapper

Candy Warpper is a library mod I use in many of my mods. You are free to use it in your mods.

Things made player riding possible:

- Redirect `isSaveable()` in `addPassenger()` to a custom method which returns `isPlayer()` if not saveable.
- Send `EntityPassengersSetS2CPacket` to the vehicle player when mounting or dismounting.

Other utils:

```java
// String to int.
ItemEnchantmentsComponent.getLevel(String enchantment)

// GetOrAdd for objective.
Scoreboard.getOrAddObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat)

// For ScoreHolder.fromProfile(player.getGameProfile())
ServerPlayerEntity.getScoreHolder()

// For Entity.getCommandTags().contains(String commandTag)
Entity.hasCommandTag(String commandTag)

// GetOrAdd for bossbar.
BossBarManager.getOrAdd(Identifier id, Text displayName)

// Obviously.
BossBarManager.contains(Identifier id)

// Obviously.
BossBarManager.remove(Identifier id)

// Return NbtList `status_effects` in NbtComponent `minecraft:custom_data`.
ItemStack.getCustomStatusEffects()

// Return NbtList `modifiers` in NbtComponent `minecraft:custom_data`.
ItemStack.getCustomModifiers()

// Custom modifiers from equipped `ItemStack`.
LivingEntity.getCustomModifiers()

// Custom modifiers from equipped `ItemStack` filtered based on `attribute` field
LivingEntity.getCustomModifiers(String attribute)

// String and double to double.
LivingEntity.getCustomModifiedValue(String attribute, double base)
```

## FAQ

### Performence downside if only install the library?

Not at all. It just takes a few more milliseconds to start Minecraft. Because the purpose of this library is to provide util methods.
