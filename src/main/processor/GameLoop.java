package main.processor;

import main.core.GameRules;
import main.domain.enums.GameSymbol;
import java.util.Scanner;
import static main.processor.Constants.*;

public class GameLoop {

    public static void runGame() {
        System.out.println(WELCOME_MESSAGE);
        Scanner gameScanner = new Scanner(System.in);
        GameRules gameRules = new GameRulesImpl();
        boolean isRunning;
        int winningCounter = 0, loosingCounter = 0, tyingCounter = 0;

        do {
            int playerChoice = gameRules.checksSymbol(gameScanner);

            GameSymbol playerMove = gameRules.getPlayerMove(playerChoice);
            GameSymbol cpuMove = gameRules.getCpuMove();

            System.out.println("Your Choice: " + playerMove.getEmojiSymbol());
            System.out.println("CPU Choice: " + cpuMove.getEmojiSymbol());

            String resultMessage = gameRules.checksResults(playerMove, cpuMove);
            System.out.println(resultMessage);

            if (resultMessage.equals(WINNER_MESSAGE)) { winningCounter++; }
            else if (resultMessage.equals(LOOSER_MESSAGE)) { loosingCounter++; }
            else { tyingCounter++; }

            isRunning = gameRules.checksContinuity(gameScanner);
        } while (isRunning);

        gameScanner.close();
        gameRules.printGameResults(winningCounter, loosingCounter, tyingCounter);
    }
}
