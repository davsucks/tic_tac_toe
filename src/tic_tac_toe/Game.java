package tic_tac_toe;

import java.io.PrintStream;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Game {

    private final Board board;
    private Player player;
    private PrintStream printStream;

    public Game(Board board, Player player, PrintStream printStream) {
        this.board = board;
        this.player = player;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println(board.buildBoard());
        board.markCell(player.getPlayersInput());
        printStream.println(board.buildBoard());
    }
}
