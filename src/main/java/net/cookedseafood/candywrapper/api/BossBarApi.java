package net.cookedseafood.candywrapper.api;

import java.util.Arrays;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.util.Formatting;

public interface BossBarApi {
    public abstract class Colors {
        public static String getName(Formatting format) {
            return Arrays.stream(BossBar.Color.values())
                .filter(color -> color.getTextFormat().equals(format))
                .map(color -> color.getName())
                .findAny()
                .orElse("");
        }

        public static Formatting getFormat(String name) {
            return Arrays.stream(BossBar.Color.values())
                .filter(color -> color.getName().equals(name))
                .map(color -> color.getTextFormat())
                .findAny()
                .orElse(Formatting.RESET);
        }

        public static BossBar.Color byName(String name) {
            return Arrays.stream(BossBar.Color.values())
                .filter(color -> color.getName().equals(name))
                .findAny()
                .get();
        }

        public static BossBar.Color byFormat(Formatting format) {
            return Arrays.stream(BossBar.Color.values())
                .filter(color -> color.getTextFormat().equals(format))
                .findAny()
                .get();
        }
    }

    public abstract class Styles {
        public static BossBar.Style byName(String name) {
            return Arrays.stream(BossBar.Style.values())
                .filter(style -> style.getName().equals(name))
                .findAny()
                .get();
        }
    }
}
