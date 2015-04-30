package tic_tac_toe;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Board {
    private PrintStream printStream;
    private String[] gameBoard;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        this.gameBoard = new String[9];
        for (int i = 0; i < 9; i++) {
            gameBoard[i] = " ";
        }
    }

    public void draw() {
        printStream.println(
                " " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " \n" +
                "-----------\n" +
                " " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " \n" +
                "-----------\n" +
                " " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
    }

    public void markCell(String s) {
        gameBoard[normalizeUserInput(s)] = "X";
    }

    private int normalizeUserInput(String s) {
        return parseIntFromUserInput(s) - 1;
    }

    private int parseIntFromUserInput(String s) {
        return Integer.parseInt(s);
    }
}
