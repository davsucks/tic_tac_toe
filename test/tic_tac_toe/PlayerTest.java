package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by dsucksto on 4/30/15.
 */
public class PlayerTest {

    private UserInputStream userInputStream;
    private Player player;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        player = new Player(userInputStream);
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(userInputStream.getUserInput()).thenReturn("");

        player.prompt();
        verify(userInputStream).getUserInput();
    }
}