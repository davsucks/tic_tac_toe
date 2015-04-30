package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Player player = new Player();
        Game game = new Game(new Board(printStream), player);
        game.start();
    }
}
