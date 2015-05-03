package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        UserInputStream userInputStream = new UserInputStream();
        Board board = new Board(initializeEmptyBoard());
        Player playerOne = new Player(userInputStream, printStream, 'X', board);
        Player playerTwo = new Player(userInputStream, printStream, 'O', board);
        Game game = new Game(board, playerOne, printStream, playerTwo);
        game.start();
    }

    private static char[] initializeEmptyBoard() {
        char[] gameBoard = new char[9];
        for (int index = 0; index < 9; index++) {
            gameBoard[index] = ' ';
        }
        return gameBoard;
    }
}
