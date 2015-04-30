package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void draw() {
        printStream.println(
                "   |   |\n" +
                "-----------\n" +
                "   |   |\n" +
                "-----------\n" +
                "   |   |");
    }
}
