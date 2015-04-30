package tic_tac_toe;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Player {
    private UserInputStream userInputStream;

    public Player(UserInputStream userInputStream) {
        this.userInputStream = userInputStream;
    }

    public void prompt() {
        String userInput = userInputStream.getUserInput();
    }
}
