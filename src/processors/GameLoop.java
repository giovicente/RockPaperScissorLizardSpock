package processors;

import core.GameRules;
import domain.enums.GameSymbol;

import java.util.Scanner;
public class GameLoop {

    public static void runGame() {
        System.out.println("Welcome to the Rock, Paper, Scissors, Lizard and Spock Game!");
        Scanner gameScanner = new Scanner(System.in);
        GameRules gameRules = new GameRulesImpl();
        char playAgain;

        do {
            int playerChoice = gameRules.checksSymbol(gameScanner);

            GameSymbol playerMove = gameRules.getPlayerMove(playerChoice);
            GameSymbol cpuMove = gameRules.getCpuMove();

            System.out.println("Your Choice: " + playerMove.getEmojiSymbol());
            System.out.println("CPU Choice: " + cpuMove.getEmojiSymbol());

            System.out.println(gameRules.checksResults(playerMove, cpuMove));

            playerChoice = initializeSymbolValue();
            playAgain = gameRules.checksContinuity(gameScanner);

        } while (playAgain == 'Y');
    }

    private static int initializeSymbolValue() {
        return -1;
    }
}
