package test.domain;

import main.domain.WinningConditions;
import main.domain.enums.GameSymbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static main.processor.Constants.WINNER_MESSAGE;

public class WinningConditionsTest {
    @Test
    void createValidWinningConditionsMapTest() {
        Map<GameSymbol, Map<GameSymbol, String>> expectedWinningConditions = new HashMap<>();

        Map<GameSymbol, String> rockWins = new HashMap<>();
        rockWins.put(GameSymbol.SCISSORS, WINNER_MESSAGE);
        rockWins.put(GameSymbol.LIZARD, WINNER_MESSAGE);

        Map<GameSymbol, String> paperWins = new HashMap<>();
        paperWins.put(GameSymbol.ROCK, WINNER_MESSAGE);
        paperWins.put(GameSymbol.SPOCK, WINNER_MESSAGE);

        Map<GameSymbol, String> scissorsWins = new HashMap<>();
        scissorsWins.put(GameSymbol.PAPER, WINNER_MESSAGE);
        scissorsWins.put(GameSymbol.LIZARD, WINNER_MESSAGE);

        Map<GameSymbol, String> lizardWins = new HashMap<>();
        lizardWins.put(GameSymbol.PAPER, WINNER_MESSAGE);
        lizardWins.put(GameSymbol.SPOCK, WINNER_MESSAGE);

        Map<GameSymbol, String> spockWins = new HashMap<>();
        spockWins.put(GameSymbol.ROCK, WINNER_MESSAGE);
        spockWins.put(GameSymbol.SCISSORS, WINNER_MESSAGE);

        expectedWinningConditions.put(GameSymbol.ROCK, rockWins);
        expectedWinningConditions.put(GameSymbol.PAPER, paperWins);
        expectedWinningConditions.put(GameSymbol.SCISSORS, scissorsWins);
        expectedWinningConditions.put(GameSymbol.LIZARD, lizardWins);
        expectedWinningConditions.put(GameSymbol.SPOCK, spockWins);

        Map<GameSymbol, Map<GameSymbol, String>> actualWinningConditions = WinningConditions.getInstance();
        Assertions.assertEquals(expectedWinningConditions, actualWinningConditions);
    }

    @Test
    void createInvalidWinningConditionsMapTest() {
        Map<GameSymbol, Map<GameSymbol, String>> unexpectedWinningConditions = new HashMap<>();

        Map<GameSymbol, String> rockWins = new HashMap<>();
        rockWins.put(GameSymbol.SCISSORS, WINNER_MESSAGE);

        Map<GameSymbol, String> paperWins = new HashMap<>();
        paperWins.put(GameSymbol.ROCK, WINNER_MESSAGE);

        Map<GameSymbol, String> scissorsWins = new HashMap<>();
        scissorsWins.put(GameSymbol.PAPER, WINNER_MESSAGE);

        Map<GameSymbol, String> lizardWins = new HashMap<>();
        lizardWins.put(GameSymbol.PAPER, WINNER_MESSAGE);

        Map<GameSymbol, String> spockWins = new HashMap<>();
        spockWins.put(GameSymbol.ROCK, WINNER_MESSAGE);

        unexpectedWinningConditions.put(GameSymbol.ROCK, rockWins);
        unexpectedWinningConditions.put(GameSymbol.PAPER, paperWins);
        unexpectedWinningConditions.put(GameSymbol.SCISSORS, scissorsWins);
        unexpectedWinningConditions.put(GameSymbol.LIZARD, lizardWins);
        unexpectedWinningConditions.put(GameSymbol.SPOCK, spockWins);

        Map<GameSymbol, Map<GameSymbol, String>> actualWinningConditions = WinningConditions.getInstance();
        Assertions.assertNotEquals(unexpectedWinningConditions, actualWinningConditions);
    }
}
