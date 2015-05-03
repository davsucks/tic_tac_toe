package tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dsucksto on 4/30/15.
 */
public class BoardTest {

    private Board emptyBoard;
    private Board fullBoard;
    char[] emptyGameBoardArray;
    char[] fullGameBoardArray;

    @Before
    public void setUp() throws Exception {
        emptyGameBoardArray = new char[9];
        fullGameBoardArray = new char[9];
        for (int index = 0; index < 9; index++) {
            emptyGameBoardArray[index] = ' ';
            fullGameBoardArray[index] = 'X';
        }
        emptyBoard = new Board(emptyGameBoardArray);
        fullBoard = new Board(fullGameBoardArray);
    }

    @Test
    public void shouldLeaveAnXOnTheMarkedCell() {
        String firstCellMarked = " X |   |   \n" +
                                 "-----------\n" +
                                 "   |   |   \n" +
                                 "-----------\n" +
                                 "   |   |  ";
        emptyBoard.markCell(1, 'X');
        assertEquals(emptyBoard.buildBoard(), firstCellMarked);
    }

    @Test
    public void shouldLetUserChooseInvalidCell() {
        String initialBoard = emptyBoard.buildBoard();
        emptyBoard.markCell(100, 'X');
        assertEquals(emptyBoard.buildBoard(), initialBoard);
    }

    @Test
    public void shouldBuildEmptyBoardWhenNoCellsAreMarked() {
        String emptyBoard = "   |   |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |  ";
        assertEquals(this.emptyBoard.buildBoard(), emptyBoard);
    }

    @Test
    public void shouldMarkCellWithSymbolGiven() {
        String finalBoard = "   | O |   \n" +
                            "-----------\n" +
                            "   |   |   \n" +
                            "-----------\n" +
                            "   |   |  ";
        emptyBoard.markCell(2, 'O');
        assertEquals(emptyBoard.buildBoard(), finalBoard);
    }

    @Test
    public void shouldNotMarkCellThatHasAlreadyBeenMarked() {
        emptyBoard.markCell(1, 'X');
        assertFalse(emptyBoard.markCell(1, 'X'));
    }

    @Test
    public void shouldBeAbleToTellWhenBoardIsFull() {
        assertTrue(fullBoard.isFull());
    }
}