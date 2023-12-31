package test.processor;

import main.core.processor.GameRules;
import main.domain.enums.GameSymbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.processor.GameRulesImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import static main.processor.Constants.*;

class GameRulesImplTest {

    GameRules gameRules = new GameRulesImpl();

    // Get player move tests
    @Test
    void getPlayerMoveRockTest() {
        final int ROCK_OPTION = 0;

        GameSymbol expectedGameSymbol = GameSymbol.ROCK;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(ROCK_OPTION);

        Assertions.assertEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMovePaperTest() {
        final int PAPER_OPTION = 1;

        GameSymbol expectedGameSymbol = GameSymbol.PAPER;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(PAPER_OPTION);

        Assertions.assertEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMoveScissorsTest() {
        final int SCISSORS_OPTION = 2;

        GameSymbol expectedGameSymbol = GameSymbol.SCISSORS;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(SCISSORS_OPTION);

        Assertions.assertEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMoveLizardTest() {
        final int LIZARD_OPTION = 3;

        GameSymbol expectedGameSymbol = GameSymbol.LIZARD;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(LIZARD_OPTION);

        Assertions.assertEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMoveSpockTest() {
        final int SPOCK_OPTION = 4;

        GameSymbol expectedGameSymbol = GameSymbol.SPOCK;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(SPOCK_OPTION);

        Assertions.assertEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMoveInvalidInputTest() {
        final int SPOCK_OPTION = 4;

        GameSymbol expectedGameSymbol = GameSymbol.ROCK;
        GameSymbol actualGameSymbol = gameRules.getPlayerMove(SPOCK_OPTION);

        Assertions.assertNotEquals(expectedGameSymbol, actualGameSymbol);
    }

    @Test
    void getPlayerMoveOutOfBoundsExceptionNegativeNumber() {
        final int PLAYER_OPTION = -1;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            GameSymbol expectedGameSymbol = gameRules.getPlayerMove(PLAYER_OPTION);
        });
    }

    @Test
    void getPlayerMoveOutOfBoundsExceptionPositiveNumber() {
        final int PLAYER_OPTION = 5;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            GameSymbol expectedGameSymbol = gameRules.getPlayerMove(PLAYER_OPTION);
        });
    }

    // Get CPU move test
    @Test
    void getCpuMoveTest() {
        GameSymbol cpuMove = gameRules.getCpuMove();
        Assertions.assertNotNull(cpuMove);
    }

    // Tie game test
    @Test
    void checksResultsTie() {
        GameSymbol playerMove = GameSymbol.SPOCK;
        GameSymbol cpuMove = GameSymbol.SPOCK;

        String expectedResult = TIE_MESSAGE;
        String actualString = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualString);
    }

    // Rock scenarios
    @Test
    void checksResultsRockWinsScissors() {
        GameSymbol playerMove = GameSymbol.ROCK;
        GameSymbol cpuMove = GameSymbol.SCISSORS;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsRockWinsLizard() {
        GameSymbol playerMove = GameSymbol.ROCK;
        GameSymbol cpuMove = GameSymbol.LIZARD;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsRockLosesPaper() {
        GameSymbol playerMove = GameSymbol.ROCK;
        GameSymbol cpuMove = GameSymbol.PAPER;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsRockLosesSpock() {
        GameSymbol playerMove = GameSymbol.ROCK;
        GameSymbol cpuMove = GameSymbol.SPOCK;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Paper scenarios
    @Test
    void checksResultsPaperWinsRock() {
        GameSymbol playerMove = GameSymbol.PAPER;
        GameSymbol cpuMove = GameSymbol.ROCK;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsPaperWinsSpock() {
        GameSymbol playerMove = GameSymbol.PAPER;
        GameSymbol cpuMove = GameSymbol.SPOCK;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsPaperLosesScissors() {
        GameSymbol playerMove = GameSymbol.PAPER;
        GameSymbol cpuMove = GameSymbol.SCISSORS;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsPaperLosesLizard() {
        GameSymbol playerMove = GameSymbol.PAPER;
        GameSymbol cpuMove = GameSymbol.LIZARD;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Scissors scenarios
    @Test
    void checksResultsScissorsWinsPaper() {
        GameSymbol playerMove = GameSymbol.SCISSORS;
        GameSymbol cpuMove = GameSymbol.PAPER;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsScissorsWinsLizard() {
        GameSymbol playerMove = GameSymbol.SCISSORS;
        GameSymbol cpuMove = GameSymbol.LIZARD;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsScissorsLosesRock() {
        GameSymbol playerMove = GameSymbol.SCISSORS;
        GameSymbol cpuMove = GameSymbol.ROCK;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsScissorsLosesSpock() {
        GameSymbol playerMove = GameSymbol.SCISSORS;
        GameSymbol cpuMove = GameSymbol.SPOCK;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Lizard Scenarios
    @Test
    void checksResultsLizardWinsPaper() {
        GameSymbol playerMove = GameSymbol.LIZARD;
        GameSymbol cpuMove = GameSymbol.PAPER;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsLizardWinsSpock() {
        GameSymbol playerMove = GameSymbol.LIZARD;
        GameSymbol cpuMove = GameSymbol.SPOCK;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsLizardLosesRock() {
        GameSymbol playerMove = GameSymbol.LIZARD;
        GameSymbol cpuMove = GameSymbol.ROCK;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsLizardLosesScissors() {
        GameSymbol playerMove = GameSymbol.LIZARD;
        GameSymbol cpuMove = GameSymbol.SCISSORS;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Spock scenarios
    @Test
    void checksResultsSpockWinsRock() {
        GameSymbol playerMove = GameSymbol.SPOCK;
        GameSymbol cpuMove = GameSymbol.ROCK;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsSpockWinsScissors() {
        GameSymbol playerMove = GameSymbol.SPOCK;
        GameSymbol cpuMove = GameSymbol.SCISSORS;

        String expectedResult = WINNER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsSpockLosesPaper() {
        GameSymbol playerMove = GameSymbol.SPOCK;
        GameSymbol cpuMove = GameSymbol.PAPER;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void checksResultsSpockLosesLizard() {
        GameSymbol playerMove = GameSymbol.SPOCK;
        GameSymbol cpuMove = GameSymbol.LIZARD;

        String expectedResult = LOOSER_MESSAGE;
        String actualResult = gameRules.checksResults(playerMove, cpuMove);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Verify valid input scenarios
    @Test
    void checksSymbolTestValidInput() {
        Random randomIndex = new Random();
        String validOptions = "01234";
        String playerInputAndExpectedResult = String.valueOf(validOptions.charAt(randomIndex.nextInt(validOptions.length())));

        InputStream in = new ByteArrayInputStream(playerInputAndExpectedResult.getBytes());
        System.setIn(in);
        Scanner scanOption = new Scanner(System.in);

        int actualResult = gameRules.checksSymbol(scanOption);

        Assertions.assertEquals(Integer.parseInt(playerInputAndExpectedResult), actualResult);
    }

    // Verify game symbols scenarios
    @Test
    void isInvalidSymbolTestTruePositiveNumber() {
        final int INVALID_OPTION = 5;
        Assertions.assertTrue(GameRulesImpl.isInvalidSymbol(INVALID_OPTION));
    }

    @Test
    void isInvalidSymbolTestTrueNegativeNumber() {
        final int INVALID_OPTION = -1;
        Assertions.assertTrue(GameRulesImpl.isInvalidSymbol(INVALID_OPTION));
    }

    @Test
    void isInvalidSymbolTestFalse() {
        final int MIN = 0, MAX = 4;
        int validOption = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        Assertions.assertFalse(GameRulesImpl.isInvalidSymbol(validOption));
    }

    // Test continuity answer scenarios
    @Test
    void isInvalidContinuityAnswerTestFalse() {
        Random randomIndex = new Random();

        String validContinuityChars = "YN";
        char continuityAnswer = validContinuityChars.charAt(randomIndex.nextInt(validContinuityChars.length()));

        Assertions.assertFalse(GameRulesImpl.isInvalidContinuityAnswer(continuityAnswer));
    }

    @Test
    void isInvalidContinuityAnswerTestTrue() {
        Random randomIndex = new Random();

        String invalidContinuityChars = "ABCDEFGHIJKLMOPQRSTUVXZ1234567890";
        char continuityAnswer = invalidContinuityChars.charAt(randomIndex.nextInt(invalidContinuityChars.length()));

        Assertions.assertTrue(GameRulesImpl.isInvalidContinuityAnswer(continuityAnswer));
    }
}
