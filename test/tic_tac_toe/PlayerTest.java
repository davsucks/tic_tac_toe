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

    @Before
    public void setUp() {

    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        UserInputStream userInputStream = mock(UserInputStream.class);
        when(userInputStream.getUserInput()).thenReturn("");

        Player player = new Player(userInputStream);

        player.prompt();
        verify(userInputStream).getUserInput();
    }
}