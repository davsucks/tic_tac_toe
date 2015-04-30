package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dsucksto on 4/30/15.
 */
public class GameTest {

    private Player player;
    private Board board;
    private Game game;

    @Before
    public void setUp() throws Exception {
        player = mock(Player.class);
        board = mock(Board.class);
        game = new Game(board, player);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        game.start();

        verify(board).draw();
    }

    @Test
    public void shouldPromptPlayerAfterDrawingBoard() {
        game.start();

        verify(board).draw();
        verify(player).prompt();
    }
}