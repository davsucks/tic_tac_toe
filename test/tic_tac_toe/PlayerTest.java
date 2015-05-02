package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        player.prompt();
        verify(printStream).println(contains("Please input"));
    }

    @Test
    public void shouldHaveAMethodToReturnAPlayersCharacterSymbol() {
        assertEquals(player.getSymbol(), playerSymbol);
    }

    @Test
    public void shouldMarkBoardWhenPlayerTakesTurn() throws Exception {
        when(userInputStream.getIntFromUser()).thenReturn(1);
        player.takeTurn();
        verify(board).markCell(1, playerSymbol);

    }
}