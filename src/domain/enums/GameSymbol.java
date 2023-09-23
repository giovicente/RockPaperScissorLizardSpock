package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameSymbol {
    ROCK("🪨"),
    PAPER("📃"),
    SCISSOR("✂️");

    private String emojiSymbol;
}
