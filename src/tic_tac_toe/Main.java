package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        UserInputStream userInputStream = new UserInputStream();
        Player playerOne = new Player(userInputStream, printStream, 'X');
        Player playerTwo = new Player(userInputStream, printStream, 'O');
        Game game = new Game(new Board(), playerOne, printStream, playerTwo);
        game.start();
    }
}
