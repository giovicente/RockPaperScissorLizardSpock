package main.core.processor;

import main.domain.enums.GameSymbol;

import java.util.Scanner;

public interface GameRules {
    GameSymbol getPlayerMove(int playerOption);
    GameSymbol getCpuMove();
    String checksResults(GameSymbol playerMove, GameSymbol cpuMove);
    boolean checksContinuity(Scanner gameScanner);
    int checksSymbol(Scanner gameScanner);
}
