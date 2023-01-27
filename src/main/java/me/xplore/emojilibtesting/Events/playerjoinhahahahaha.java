package me.xplore.emojilibtesting.Events;

import me.xplore.emojilib.Classes.Emoji;
import me.xplore.emojilib.EmojiLib;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class playerjoinhahahahaha implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        List<String> emojiList = new ArrayList<String>();
        for(Emoji e : EmojiLib.getEmojiRenderer().emojiList) {
            emojiList.add(e.getEmojiNameWithColons());
        }
        p.addAdditionalChatCompletions(emojiList);
    }
}
