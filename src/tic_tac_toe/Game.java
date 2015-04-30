package tic_tac_toe;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Game {

    private final Board board;
    private Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public void start() {
        board.draw();
        board.markCell(player.getPlayersInput());
        board.draw();
    }
}
