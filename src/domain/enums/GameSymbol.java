package domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameSymbol {
    ROCK("🪨"),
    PAPER("📃"),
    SCISSORS("✂️"),
    LIZARD("🦎"),
    SPOCK("🖖🏼");

    private String emojiSymbol;
}
