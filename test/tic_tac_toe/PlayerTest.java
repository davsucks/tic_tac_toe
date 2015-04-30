package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

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

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        player = new Player(userInputStream, printStream);
    }

    @Test
    public void shouldPromptUserForInputWhenCollectingMove() {
        when(userInputStream.getUserInput()).thenReturn("");

        player.getPlayersInput();
        verify(userInputStream).getUserInput();
    }

    @Test
    public void shouldInstructUserHowToInput() {
        when(userInputStream.getUserInput()).thenReturn("");

        player.prompt();
        verify(printStream).println(contains("Please input"));
    }

    
}