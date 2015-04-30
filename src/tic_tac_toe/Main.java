package tic_tac_toe;

/**
 * Created by dsucksto on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Board());
        game.start();
    }
}
