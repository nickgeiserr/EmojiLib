package me.xplore.emojilib.Classes;

import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class EmojiRenderer implements Listener {

    MiniMessage miniMessage = MiniMessage.miniMessage();

    // var decs
    public final List<Emoji> emojiList = new ArrayList<Emoji>();
    public void registerEmoji(Emoji e) {
        if(emojiList.contains(e))
            return;
        emojiList.add(e);
    }

    @EventHandler
    public void sendMessage(AsyncChatDecorateEvent event) {
        Component message = event.originalMessage();
        // this is so sad :sob:
        // this so sad 箅
        for(Emoji e : emojiList) {
            message = message.replaceText(TextReplacementConfig.builder()
                    .matchLiteral(e.getEmojiNameWithColons())
                    .replacement(miniMessage.deserialize("<hover:show_text:'<red>" + e.getCorrespondingInGameCharacter() + e.getEmojiNameWithColons() + "'>" + e.getCorrespondingInGameCharacter() + "</hover>"))
                    .build());
        }

        event.result(message);
    }
}
