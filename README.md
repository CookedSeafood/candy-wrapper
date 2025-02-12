# CandyWrapper

CandyWarpper is a library mod I use in many of my mods. You are free to use it in your mods.

Things made player riding possible:

- Redirect `isSaveable()` in `addPassenger()` to a custom method which returns `isPlayer()` if not saveable.
- Send `EntityPassengersSetS2CPacket` to the vehicle player when mounting or dismounting.

Other utils:

- `ItemEnchantmentsComponent.getLevel(String enchantment)` String to int.
- `Scoreboard.getOrAddObjective(String name, ScoreboardCriterion criterion, Text displayName, ScoreboardCriterion.RenderType renderType, boolean displayAutoUpdate, @Nullable NumberFormat numberFormat)` GetOrAdd for objective.
- `ServerPlayerEntity.getScoreHolder()` for `ScoreHolder.fromProfile(player.getGameProfile())`.
- `Entity.hasCommandTag(String commandTag)` for `Entity.getCommandTags().contains(String commandTag)`
- `ItemStack.getCustomModifiers()` get NbtList `modifiers` in NbtComponent `minecraft:custom_data`.
