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

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDisplayBoardWhenDrawn() {
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
        board.markCell(1);
        board.draw();

        verify(printStream).println(contains(
                " X |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |  "));
    }

    @Test
    public void shouldLetUserChooseInvalidCell() {
        board.markCell(100);
        board.draw();

        verify(printStream).println(contains(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |  "));
    }
}