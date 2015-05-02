package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Player {
    private UserInputStream userInputStream;
    private PrintStream printStream;
    private char symbol;
    private Board board;

    public Player(UserInputStream userInputStream, PrintStream printStream, char symbol, Board board) {
        this.userInputStream = userInputStream;
        this.printStream = printStream;
        this.symbol = symbol;
        this.board = board;
    }

    public void prompt() {
        printStream.println("Please input a number between 1 and 9:");
    }

    public int getPlayersInput() {
        prompt();
        return userInputStream.getIntFromUser();
    }

    public char getSymbol() {
        return symbol;
    }

    public void takeTurn() {
        board.markCell(getPlayersInput(), symbol);
    }
}
