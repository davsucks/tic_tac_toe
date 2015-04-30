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

    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, printStream, playerTwo);
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

        InOrder inOrder = inOrder(printStream, playerOne);

        inOrder.verify(printStream).println("Board");
        inOrder.verify(playerOne).getPlayersInput();
    }

    @Test
    public void shouldMarkBoardWhenUserDecidesOnACell() {
        when(playerOne.getSymbol()).thenReturn('X');
        when(playerOne.getPlayersInput()).thenReturn(1);

        game.start();

        verify(board).markCell(1, 'X');
    }

    @Test
    public void shouldDrawBoardAgainAfterMarkingBoard() {
        when(playerOne.getPlayersInput()).thenReturn(1);
        when(board.buildBoard()).thenReturn("Board");

        game.start();

        InOrder inOrder = inOrder(printStream, playerOne);

        inOrder.verify(printStream, times(1)).println("Board");
        inOrder.verify(playerOne).getPlayersInput();
        inOrder.verify(printStream, atLeastOnce()).println("Board");

    }

    @Test
    public void shouldAlternateBetweenPromptingPlayerOneAndPlayerTwo() {
        when(playerOne.getPlayersInput()).thenReturn(1);
        when(playerOne.getSymbol()).thenReturn('X');
        when(playerTwo.getPlayersInput()).thenReturn(2);
        when(playerTwo.getSymbol()).thenReturn('O');

        game.start();

        InOrder inOrder = inOrder(board);
        inOrder.verify(board).markCell(1, 'X');
        inOrder.verify(board).markCell(2, 'O');
    }

    @Test
    public void shouldUseEachPlayersSymbolInMarkingCells() {
        when(playerOne.getPlayersInput()).thenReturn(1);
        when(playerOne.getSymbol()).thenReturn('X');
        when(playerTwo.getPlayersInput()).thenReturn(2);
        when(playerTwo.getSymbol()).thenReturn('O');

        game.start();

        verify(board).markCell(1, 'X');
        verify(board).markCell(2, 'O');
    }
}