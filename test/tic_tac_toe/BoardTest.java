package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dsucksto on 4/30/15.
 */
public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void shouldLeaveAnXOnTheMarkedCell() {
        String firstCellMarked = " X |   |   \n" +
                                 "-----------\n" +
                                 "   |   |   \n" +
                                 "-----------\n" +
                                 "   |   |  ";
        board.markCell(1);
        assertEquals(board.buildBoard(), firstCellMarked);
    }

    @Test
    public void shouldLetUserChooseInvalidCell() {
        String initialBoard = board.buildBoard();
        board.markCell(100);
        assertEquals(board.buildBoard(), initialBoard);
    }

    @Test
    public void shouldBuildEmptyBoardWhenNoCellsAreMarked() {
        String emptyBoard = "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |  ";
        assertEquals(board.buildBoard(), emptyBoard);
    }
}