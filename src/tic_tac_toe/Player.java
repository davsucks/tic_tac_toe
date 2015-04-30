package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Player {
    private UserInputStream userInputStream;
    private PrintStream printStream;
    private char symbol;

    public Player(UserInputStream userInputStream, PrintStream printStream, char symbol) {
        this.userInputStream = userInputStream;
        this.printStream = printStream;
        this.symbol = symbol;
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
}
