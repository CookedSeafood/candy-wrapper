package net.cookedseafood.candywrapper.command;

import com.mojang.brigadier.CommandDispatcher;
import net.cookedseafood.candywrapper.CandyWrapper;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class CandyWrapperCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(
            CommandManager.literal("candywrapper")
            .then(
                CommandManager.literal("version")
                .executes(context -> executeVersion((ServerCommandSource)context.getSource()))
            )
        );
    }

    public static int executeVersion(ServerCommandSource source) {
        source.sendFeedback(() -> Text.literal("Candy Wrapper " + CandyWrapper.VERSION_MAJOR + "." + CandyWrapper.VERSION_MINOR + "." + CandyWrapper.VERSION_PATCH), false);
        return 0;
    }
}
