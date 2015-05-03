package tic_tac_toe;

import java.io.PrintStream;
import java.util.ArrayList;


/**
 * Created by dsucksto on 4/30/15.
 */
public class Board {
    private ArrayList<Character> gameBoard;

    public Board(ArrayList<Character> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isCellAvailable(int cell) {
        int index = normalizeUserInput(cell);
        return gameBoard.get(index) == ' ';
    }

    public void markCell(int cell, Character symbol) {
        int index = normalizeUserInput(cell);
        gameBoard.set(index, symbol);

    }

    private int normalizeUserInput(int userInput) {
        return userInput - 1;
    }

    public String buildBoard() {
        return " " + gameBoard.get(0) + " | " + gameBoard.get(1) + " | " + gameBoard.get(2) + " \n" +
                "-----------\n" +
                " " + gameBoard.get(3) + " | " + gameBoard.get(4) + " | " + gameBoard.get(5) + " \n" +
                "-----------\n" +
                " " + gameBoard.get(6) + " | " + gameBoard.get(7) + " | " + gameBoard.get(8);
    }

    public boolean isFull() {
        return !gameBoard.contains(' ');
    }

    public boolean playerHasWon(char x) {
        return false;
    }

    public Character getCell(int index) {
        return gameBoard.get(normalizeUserInput(index));
    }
}
