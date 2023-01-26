package me.xplore.emojilib.Classes;

public class Emoji {
    private final String emojiName;
    private final char correspondingInGameCharacter;
    public Emoji(String emojiName, char correspondingInGameCharacter) {
        this.emojiName = emojiName;
        this.correspondingInGameCharacter = correspondingInGameCharacter;
    }

    public char getCorrespondingInGameCharacter() {
        return correspondingInGameCharacter;
    }

    public String getEmojiName() {
        return emojiName;
    }
}
