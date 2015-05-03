package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Game {

    private final Board board;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    public Game(Board board, Player playerOne, PrintStream printStream, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println(board.buildBoard());
        while(!board.isFull()) {
            playerOne.takeTurn();
            if (board.isFull()) {
                break;
            }
            printStream.println(board.buildBoard());
            playerTwo.takeTurn();
            printStream.println(board.buildBoard());
        }
        finishGame();
    }

    private void finishGame() {
        printStream.println(board.buildBoard());
        printStream.println("Game is a draw.");
    }
}
