package core;

import domain.enums.GameSymbol;

import java.util.Scanner;

public interface GameRules {
    GameSymbol getPlayerMove(int playerOption);
    GameSymbol getCpuMove();
    String checksResults(GameSymbol playerMove, GameSymbol cpuMove);
    char checksContinuity(Scanner gameScanner);
    int checksSymbol(Scanner gameScanner);
}
