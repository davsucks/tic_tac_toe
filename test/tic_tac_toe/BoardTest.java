package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dsucksto on 4/30/15.
 */
public class BoardTest {

    @Test
    public void shouldDisplayBoardWhenDrawn() {
        PrintStream printStream = mock(PrintStream.class);

        Board board = new Board(printStream);

        board.draw();
        verify(printStream).println(contains(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |  "));
    }

    @Test
    public void shouldLeaveAnXOnTheMarkedCell() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.markCell("1");
        board.draw();
        verify(printStream).println(contains(
                " X |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |  "));
    }
}