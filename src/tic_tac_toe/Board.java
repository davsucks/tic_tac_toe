package tic_tac_toe;

import java.io.PrintStream;
import java.util.ArrayList;


/**
 * Created by dsucksto on 4/30/15.
 */
public class Board {
    private ArrayList<ArrayList<Character>> gameBoard;

    public Board(ArrayList<ArrayList<Character>> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isCellAvailable(int cell) {
        int index = normalizeUserInput(cell);
        int row = index == 0 ? 0 : index / 3;
        int col = index % 3;
        return gameBoard.get(row).get(col) == ' ';
    }

    public void markCell(int cell, Character symbol) {
        int index = normalizeUserInput(cell);
        int row = index == 0 ? 0 : index / 3;
        int col = index % 3;
        gameBoard.get(row).set(col, symbol);

    }

    private int normalizeUserInput(int userInput) {
        return userInput - 1;
    }

    public String buildBoard() {
        return " " + gameBoard.get(0).get(0) + " | " + gameBoard.get(0).get(1) + " | " + gameBoard.get(0).get(2) + " \n" +
                "-----------\n" +
                " " + gameBoard.get(1).get(0) + " | " + gameBoard.get(1).get(1) + " | " + gameBoard.get(0).get(2) + " \n" +
                "-----------\n" +
                " " + gameBoard.get(2).get(0) + " | " + gameBoard.get(2).get(1) + " | " + gameBoard.get(2).get(2);
    }

    public boolean isFull() {
        for (ArrayList<Character> row : gameBoard) {
            for (Character character : row) {
                if (character == ' ') {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean playerHasWon(char x) {
        return false;
    }

}
