package me.xplore.emojilibtesting;

import me.xplore.emojilib.Classes.Emoji;
import me.xplore.emojilib.Classes.EmojiRenderer;
import me.xplore.emojilib.EmojiLib;
import me.xplore.emojilibtesting.Events.PlayerChatEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Set;

public final class EmojiLibTesting extends JavaPlugin {

    @Override
    public void onEnable() {
        saveResource("emojis.yml", true);
        EmojiLib.setPlugin(this);
        YamlConfiguration emojis = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "emojis.yml"));
        Set<String> emojees = emojis.getKeys(false);
        for(String key : emojees) {
            EmojiLib.getEmojiRenderer().registerEmoji(new Emoji(key, emojis.getString(key)));
        }

        getServer().getPluginManager().registerEvents(EmojiLib.getEmojiRenderer(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
