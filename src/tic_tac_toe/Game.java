package tic_tac_toe;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.draw();
    }
}
