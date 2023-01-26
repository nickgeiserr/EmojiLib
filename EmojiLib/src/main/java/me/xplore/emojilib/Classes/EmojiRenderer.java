package me.xplore.emojilib.Classes;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class EmojiRenderer {
    // var decs
    private static List<Emoji> emojiList = new ArrayList<Emoji>();
    private static char emojiStarterAndEnder = ':';

    private String emojiNonExistentResponseMessage = ChatColor.RED + "This Emoji Does not Exist!";

    // getters and setters

    public static List<Emoji> getEmojiList() {
        return emojiList;
    }
    public static void registerEmoji(Emoji e) {
        if(emojiList.contains(e))
            return;
        emojiList.add(e);
    }

    public static char getEmojiStarterAndEnder() {
        return emojiStarterAndEnder;
    }
    public static void setEmojiStarterAndEnder(char emojiStarterAndEnder_n) {
        if(emojiStarterAndEnder_n == ' ')
            return;
        emojiStarterAndEnder = emojiStarterAndEnder_n;
    }

    // class methods

    private static boolean doesEmojiExist(String name) {
        name = name.substring(1, name.length()-1);
        for(Emoji e : emojiList) {
            if(e.getEmojiName() == name)
                return true;
        }
        return false;
    }

    private static boolean isEmoji(String word) {
        if(word.startsWith(String.valueOf(emojiStarterAndEnder)) && word.endsWith(String.valueOf(emojiStarterAndEnder))) {
            if(doesEmojiExist(word))
                return true;
        }
        return false;
    }

    private static Emoji getEmojiFromNameWithStartAndEnder(String name) {
        name = name.substring(1, name.length()-1);
        for(Emoji e : emojiList) {
            if(e.getEmojiName() == name)
                return e;
        }
        return new Emoji("default_text", 'X');
    }

    public static void sendMessage(PlayerChatEvent event) {
        BaseComponent message = new TextComponent();
        String[] parts = event.getMessage().split(" ");

        for(String currentWord : parts) {
            if(isEmoji(currentWord)) {
                message.addExtra(new TextComponent(" " + String.valueOf(getEmojiFromNameWithStartAndEnder(currentWord).getCorrespondingInGameCharacter()) + " "));
            }
            message.addExtra(" " + currentWord + " ");
        }
    }
}
