package tic_tac_toe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dsucksto on 4/30/15.
 */
public class UserInputStream {
    private int ERROR = -1;

    public int getIntFromUser() {
        String inputLine = null;
        int intFromUser = ERROR;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return ERROR;
            intFromUser = Integer.parseInt(inputLine);

        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e);
        }
        return intFromUser;
    }
}
