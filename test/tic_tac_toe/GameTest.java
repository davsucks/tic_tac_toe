package tic_tac_toe;

import org.junit.Before;
import org.junit.Ignore;
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
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream, atLeastOnce()).println("Board");
    }

    @Test
    public void shouldTellPlayerToTakeTurnAfterDrawingBoard() {
        String testBoard = "Board";
        when(board.buildBoard()).thenReturn(testBoard);
        when(board.isFull()).thenReturn(false, true);

        game.start();

        InOrder inOrder = inOrder(printStream, playerOne);

        inOrder.verify(printStream).println(testBoard);
        inOrder.verify(playerOne).takeTurn();
    }

    @Test
    public void shouldDrawBoardAgainAfterPlayerTakesTurn() {
        String testBoard = "Board";
        when(board.buildBoard()).thenReturn(testBoard);
        when(board.isFull()).thenReturn(false, true);

        game.start();

        InOrder inOrder = inOrder(printStream, playerOne);

        inOrder.verify(printStream, times(1)).println(testBoard);
        inOrder.verify(playerOne).takeTurn();
        inOrder.verify(printStream, atLeastOnce()).println(testBoard);

    }

    @Test
    public void shouldAlternateBetweenPlayerOneAndPlayerTwo() {
        when(board.isFull()).thenReturn(false, false, true);
        game.start();

        InOrder inOrder = inOrder(playerOne, playerTwo);
        inOrder.verify(playerOne).takeTurn();
        inOrder.verify(playerTwo).takeTurn();
    }

    @Test
    public void shouldAlternatePlayersUntilBoardIsFull() {
        when(board.isFull()).thenReturn(false, false, false, false, true);

        game.start();

        verify(playerOne, times(2)).takeTurn();
        verify(playerTwo, times(2)).takeTurn();
    }

    @Test
    public void shouldTellPlayersGameIsADraw() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream).println(contains("Game is a draw"));
    }
}