package main.domain;

import main.domain.enums.GameSymbol;

import java.util.HashMap;
import java.util.Map;

import static main.processor.Constants.WINNER_MESSAGE;

public class WinningConditions {

    private static Map<GameSymbol, Map<GameSymbol, String>> conditions;

    public final static Map<GameSymbol, Map<GameSymbol, String>> getInstance() {
        conditions = new HashMap<>();

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

        conditions.put(GameSymbol.ROCK, rockWins);
        conditions.put(GameSymbol.PAPER, paperWins);
        conditions.put(GameSymbol.SCISSORS, scissorsWins);
        conditions.put(GameSymbol.LIZARD, lizardWins);
        conditions.put(GameSymbol.SPOCK, spockWins);

        return conditions;
    }
}
