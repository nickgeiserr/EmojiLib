package me.xplore.emojilib;

import me.xplore.emojilib.Classes.EmojiRenderer;
import org.bukkit.plugin.java.JavaPlugin;

public final class EmojiLib {
    private static JavaPlugin plugin;
    private static EmojiRenderer emojiRenderer = new EmojiRenderer();

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final JavaPlugin plugin) {
        EmojiLib.plugin = plugin;
    }

    public static EmojiRenderer getEmojiRenderer() {
        return emojiRenderer;
    }

}
