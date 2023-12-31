package main.processor;

import main.core.GameRules;
import main.domain.enums.GameSymbol;

import java.util.Scanner;
import static main.processor.Constants.WELCOME_MESSAGE;

public class GameLoop {

    public static void runGame() {
        System.out.println(WELCOME_MESSAGE);
        Scanner gameScanner = new Scanner(System.in);
        GameRules gameRules = new GameRulesImpl();
        boolean isRunning;

        do {
            int playerChoice = gameRules.checksSymbol(gameScanner);

            GameSymbol playerMove = gameRules.getPlayerMove(playerChoice);
            GameSymbol cpuMove = gameRules.getCpuMove();

            System.out.println("Your Choice: " + playerMove.getEmojiSymbol());
            System.out.println("CPU Choice: " + cpuMove.getEmojiSymbol());

            System.out.println(gameRules.checksResults(playerMove, cpuMove));

            isRunning = gameRules.checksContinuity(gameScanner);

        } while (isRunning);

        gameScanner.close();
    }
}
