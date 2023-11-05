package processor;

import domain.enums.GameSymbol;
import java.util.List;

public class Constants {
    static final String WELCOME_MESSAGE = "Welcome to the Rock, Paper, Scissors, Lizard and Spock Game!!!";
    static final int MINIMUM_VALID_VALUE = 0;
    static final int MAXIMUM_VALID_VALUE = List.of(GameSymbol.values()).size();
    static final String TIE_MESSAGE = "Tie!";
    static final String WINNER_MESSAGE = "You Win!!!";
    static final String LOOSER_MESSAGE = "You Loose :(";
    static final String SYMBOL_SELECTION_MESSAGE
            = "Select your Symbol: Rock = 0, Paper = 1, Scissors = 2, Lizard = 3, Spock = 4: ";
    static final String INVALID_TYPE_SELECTION_MESSAGE
            = "Invalid answer!!! The Symbol Must be a number!!! Please Select your Symbol Correctly: Rock = 0, Paper = 1, Scissors = 2, Lizard = 3, Spock = 4: ";
    static final String INVALID_SYMBOL_SELECTION_MESSAGE
            = "Invalid answer!!! Please Select your Symbol Correctly: Rock = 0, Paper = 1, Scissors = 2, Lizard = 3, Spock = 4: ";
    static final String ANOTHER_ROUND_MESSAGE = "Do you want to play another round? [Y/N]: ";
    static final String INVALID_ANOTHER_ROUND_MESSAGE = "Invalid answer!!! Please just type 'Y' or 'N': ";
}
