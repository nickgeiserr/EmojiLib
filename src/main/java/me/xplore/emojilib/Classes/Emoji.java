package me.xplore.emojilib.Classes;

import org.jetbrains.annotations.NotNull;

public class Emoji {
    private final String emojiName;
    private final String correspondingInGameCharacter;
    public Emoji(String emojiName, String correspondingInGameCharacter) {
        this.emojiName = emojiName;
        this.correspondingInGameCharacter = correspondingInGameCharacter;
    }

    public @NotNull String getCorrespondingInGameCharacter() {
        return correspondingInGameCharacter;
    }

    public String getEmojiNameWithColons() {
        return ":" + emojiName + ":";
    }

    public String getEmojiNameWithoutColons() {
        return emojiName;
    }
}
