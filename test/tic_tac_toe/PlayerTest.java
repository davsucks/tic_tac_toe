package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by dsucksto on 4/30/15.
 */
public class PlayerTest {

    private UserInputStream userInputStream;
    private Player player;
    private PrintStream printStream;
    private char playerSymbol;
    private Board board;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        playerSymbol = 'X';
        player = new Player(userInputStream, printStream, playerSymbol, board);
    }

    @Test
    public void shouldPromptUserForInputWhenCollectingMove() {
        when(userInputStream.getIntFromUser()).thenReturn(0);

        player.getPlayersInput();

        verify(userInputStream).getIntFromUser();
    }

    @Test
    public void shouldInstructUserHowToInput() {
        when(userInputStream.getIntFromUser()).thenReturn(0);

        player.promptUserForInput();

        verify(printStream).println(contains("Please input"));
    }

    @Test
    public void shouldHaveAMethodToReturnAPlayersCharacterSymbol() {
        assertEquals(player.getSymbol(), playerSymbol);
    }

    @Test
    public void shouldMarkBoardWhenPlayerTakesTurn() {
        when(board.isCellAvailable(1)).thenReturn(true);
        when(userInputStream.getIntFromUser()).thenReturn(1);

        player.takeTurn();

        verify(board).markCell(1, playerSymbol);

    }

    @Test
    public void shouldKeepPromptingPlayerIfCellIsAlreadyTaken() {
        when(board.isCellAvailable(1)).thenReturn(false, true);
        when(userInputStream.getIntFromUser()).thenReturn(1);

        player.takeTurn();

        verify(userInputStream, atLeast(2)).getIntFromUser();
    }

    @Test
    public void shouldGiveUserAMessageWhenAMoveIsInvalid() {
        when(board.isCellAvailable(1)).thenReturn(false, true);
        when(userInputStream.getIntFromUser()).thenReturn(1);

        player.takeTurn();

        verify(printStream).println(contains("Location already taken"));
    }
}