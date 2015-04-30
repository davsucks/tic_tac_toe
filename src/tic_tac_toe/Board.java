package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Board {
    private char[] gameBoard;

    public Board() {
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        this.gameBoard = new char[9];
        for (int i = 0; i < 9; i++) {
            gameBoard[i] = ' ';
        }
    }

    public boolean markCell(int cell, char symbol) {
        int index = normalizeUserInput(cell);
        if (index >= 0 && index < 9 && gameBoard[index] == ' ') {
            gameBoard[index] = symbol;
            return true;
        }
        return false;
    }

    private int normalizeUserInput(int userInput) {
        return userInput - 1;
    }

    public String buildBoard() {
        return " " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " \n" +
                "-----------\n" +
                " " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " \n" +
                "-----------\n" +
                " " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8];
    }
}
