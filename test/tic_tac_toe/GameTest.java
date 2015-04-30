package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by dsucksto on 4/30/15.
 */
public class GameTest {

    private Player player;
    private Board board;
    private Game game;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        player = mock(Player.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, player, printStream);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        when(board.buildBoard()).thenReturn("Board");
        game.start();

        verify(printStream, atLeastOnce()).println("Board");
    }

    @Test
    public void shouldGetPlayersInputAfterDrawingBoard() {
        when(board.buildBoard()).thenReturn("Board");
        game.start();

        InOrder inOrder = inOrder(printStream, player);

        inOrder.verify(printStream).println("Board");
        inOrder.verify(player).getPlayersInput();
    }

    @Test
    public void shouldMarkBoardWhenUserDecidesOnACell() {
        when(player.getPlayersInput()).thenReturn(1);

        game.start();

        verify(board).markCell(1);
    }

    @Test
    public void shouldDrawBoardAgainAfterMarkingBoard() {
        when(player.getPlayersInput()).thenReturn(1);
        when(board.buildBoard()).thenReturn("Board");

        game.start();

        InOrder inOrder = inOrder(printStream, player);

        inOrder.verify(printStream, times(1)).println("Board");
        inOrder.verify(player).getPlayersInput();
        inOrder.verify(printStream, atLeastOnce()).println("Board");

    }
}