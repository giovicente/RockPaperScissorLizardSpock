package main.processor;

import main.core.GameRules;
import main.domain.WinningConditions;
import main.domain.enums.GameSymbol;

import java.util.*;

import static main.processor.Constants.*;

public class GameRulesImpl implements GameRules {

    @Override
    public GameSymbol getPlayerMove(int playerOption) {
        return List.of(GameSymbol.values()).get(playerOption);
    }

    @Override
    public GameSymbol getCpuMove() {
        final List<GameSymbol> GAME_SYMBOLS = List.of(GameSymbol.values());
        final int GAME_SYMBOLS_SIZE = GAME_SYMBOLS.size();
        Random cpuMove = new Random();

        return GAME_SYMBOLS.get(cpuMove.nextInt(GAME_SYMBOLS_SIZE));
    }

    @Override
    public String checksResults(GameSymbol playerMove, GameSymbol cpuMove) {
        if (playerMove.equals(cpuMove)) { return TIE_MESSAGE; }

        Map<GameSymbol, Map<GameSymbol, String>> winningConditions = WinningConditions.getInstance();
        Map<GameSymbol, String> results = winningConditions.get(playerMove);

        for (GameSymbol gameSymbol : results.keySet()) {
            if (gameSymbol.equals(cpuMove)) { return results.get(gameSymbol); }
        }

        return LOOSER_MESSAGE;
    }

    @Override
    public int checksSymbol(Scanner gameScanner) {
        System.out.println(SYMBOL_SELECTION_MESSAGE);
        int playerChoice = gameScanner.nextInt();

        while (isInvalidSymbol(playerChoice)) {
            System.out.println(INVALID_SYMBOL_SELECTION_MESSAGE);
            playerChoice = gameScanner.nextInt();
        }

        return playerChoice;
    }

    @Override
    public void printGameResults(int winningCounter, int loosingCounter, int tyingCounter) {
        System.out.println(
                "=================== RESULTS ===================\n" +
                "WINS: " + winningCounter + "\n" +
                "LOSSES: " + loosingCounter + "\n" +
                "TIES: " + tyingCounter
        );
    }

    public static boolean isInvalidSymbol(int playerChoice) {
        return (playerChoice < MINIMUM_VALID_VALUE || playerChoice > MAXIMUM_VALID_VALUE);
    }

    @Override
    public boolean checksContinuity(Scanner gameScanner) {
        System.out.println(ANOTHER_ROUND_MESSAGE);
        char playAgain = Character.toUpperCase(gameScanner.next().charAt(0));

        while (isInvalidContinuityAnswer(playAgain)) {
            System.out.println(INVALID_ANOTHER_ROUND_MESSAGE);
            playAgain = Character.toUpperCase(gameScanner.next().charAt(0));
        }

        return (playAgain == 'Y');
    }

    public static boolean isInvalidContinuityAnswer(char playAgain) {
        return (playAgain != 'Y' && playAgain != 'N');
    }

}
