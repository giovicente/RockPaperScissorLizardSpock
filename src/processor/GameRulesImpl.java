package processor;

import core.processor.GameRules;
import domain.enums.GameSymbol;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static processor.Constants.*;

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

        if (playerMove.equals(cpuMove))
            return TIE_MESSAGE;

        switch (playerMove) {
            case ROCK -> {
                if (cpuMove.equals(GameSymbol.SCISSORS) || cpuMove.equals(GameSymbol.LIZARD))
                    return WINNER_MESSAGE;
                return LOOSER_MESSAGE;
            }
            case PAPER -> {
                if (cpuMove.equals(GameSymbol.ROCK) || cpuMove.equals(GameSymbol.SPOCK))
                    return WINNER_MESSAGE;
                return LOOSER_MESSAGE;
            }
            case SCISSORS -> {
                if (cpuMove.equals(GameSymbol.PAPER) || cpuMove.equals(GameSymbol.LIZARD))
                    return WINNER_MESSAGE;
                return LOOSER_MESSAGE;
            }
            case LIZARD -> {
                if (cpuMove.equals(GameSymbol.PAPER) || cpuMove.equals(GameSymbol.SPOCK))
                    return WINNER_MESSAGE;
                return LOOSER_MESSAGE;
            }
            case SPOCK -> {
                if (cpuMove.equals(GameSymbol.ROCK) || cpuMove.equals(GameSymbol.SCISSORS))
                    return WINNER_MESSAGE;
                return LOOSER_MESSAGE;
            }
            default -> {
                return null;
            }
        }
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

    private static boolean isInvalidSymbol(int playerChoice) {
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

    private static boolean isInvalidContinuityAnswer(char playAgain) {
        return (playAgain != 'Y' && playAgain != 'N');
    }
}
