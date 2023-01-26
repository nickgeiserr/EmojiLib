package me.xplore.emojilib;

import org.bukkit.plugin.java.JavaPlugin;

public final class EmojiLib {
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final JavaPlugin plugin) {
        EmojiLib.plugin = plugin;
    }
}
