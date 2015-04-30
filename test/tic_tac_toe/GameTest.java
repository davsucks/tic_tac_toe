package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

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

        InOrder inOrder = inOrder(board, player);

        inOrder.verify(board).draw();
        inOrder.verify(player).prompt();
    }

    @Test
    public void shouldMarkBoardWhenUserDecidesOnACell() {
        when(player.getPlayersInput()).thenReturn("1");

        game.start();

        verify(board).markCell("1");
    }
}