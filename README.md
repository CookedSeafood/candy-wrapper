# Candy Wrapper

Candy Warpper is a library mod I use in many of my mods. You are free to use it in your mods.

Things made player riding possible:

- Redirect `isSaveable()` in `addPassenger()` to a custom method which returns `isPlayer()` if not saveable.
- Send `EntityPassengersSetS2CPacket` to the vehicle player when mounting or dismounting.

Other utils:

- `ItemEnchantmentsComponent.getLevel(String enchantment)` String to int.
- `Scoreboard.getOrAddObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat)` GetOrAdd for objective.
- `ServerPlayerEntity.getScoreHolder()` for `ScoreHolder.fromProfile(player.getGameProfile())`.
- `Entity.hasCommandTag(String commandTag)` for `Entity.getCommandTags().contains(String commandTag)`
- `ItemStack.getCustomStatusEffects()` NbtList `status_effects` in NbtComponent `minecraft:custom_data`.
- `ItemStack.getCustomModifiers()` NbtList `modifiers` in NbtComponent `minecraft:custom_data`.
- `LivingEntity.getCustomModifiers()` eligible custom modifiers, which from equipped `ItemStack`.
- `LivingEntity.getCustomModifiers(String attribute)` eligible custom modifiers and filter based on `attribute` field.
- `LivingEntity.getCustomModifiedValue(String attribute, double base)` String and double to double.

## FAQ

### Performence downside if only install the library?

Not at all. It just takes a few more milliseconds to start Minecraft. Because the purpose of this library is to provide util methods.
