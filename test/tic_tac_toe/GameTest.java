package tic_tac_toe;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dsucksto on 4/30/15.
 */
public class GameTest {

    @Test
    public void shouldDrawBoardWhenGameStarts() throws Exception {
        Board board = mock(Board.class);

        Game game = new Game(board);

        game.start();
        verify(board).draw();
    }
}