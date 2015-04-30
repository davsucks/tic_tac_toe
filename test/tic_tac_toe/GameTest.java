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

    @Before
    public void setUp() throws Exception {
        player = mock(Player.class);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        Board board = mock(Board.class);

        Game game = new Game(board, player);

        game.start();
        verify(board).draw();
    }

    @Test
    public void shouldPromptPlayerAfterDrawingBoard() {
        Board board = mock(Board.class);
        Game game = new Game(board, player);

        game.start();
        verify(board).draw();
        verify(player).prompt();
    }
}