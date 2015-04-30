package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Player {
    private UserInputStream userInputStream;
    private PrintStream printStream;

    public Player(UserInputStream userInputStream, PrintStream printStream) {
        this.userInputStream = userInputStream;
        this.printStream = printStream;
    }

    public void prompt() {
        printStream.println("Please input a number between 1 and 9:");
    }

    public String getPlayersInput() {
        prompt();
        return userInputStream.getUserInput();
    }
}
