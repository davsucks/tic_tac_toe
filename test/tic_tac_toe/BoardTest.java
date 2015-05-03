package tic_tac_toe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
    ArrayList<Character> emptyGameBoardArray;
    ArrayList<Character> fullGameBoardArray;

    @Before
    public void setUp() throws Exception {
        emptyGameBoardArray = new ArrayList<>(Collections.nCopies(9, ' '));
        fullGameBoardArray = new ArrayList<>(Collections.nCopies(9, 'X'));
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
    public void shouldBeAbleToTellWhenBoardIsFull() {
        assertTrue(fullBoard.isFull());
    }

    @Test
    @Ignore
    public void shouldTellWhenPlayerHasWonByRow() throws Exception {
        emptyGameBoardArray.set(0, 'X');
        emptyGameBoardArray.set(1, 'X');
        emptyGameBoardArray.set(2, 'X');

        Board winningBoard = new Board(emptyGameBoardArray);

        assertTrue(winningBoard.playerHasWon('X'));
    }

    @Test
    public void shouldInformUserIfCellIsAvailable() {
        assertTrue(emptyBoard.isCellAvailable(1));
    }

    @Test
    public void shouldInformUserIfCellIsUnavailable() {
        emptyGameBoardArray.set(0, 'X');

        assertFalse(emptyBoard.isCellAvailable(1));
    }

    @Test
    public void shouldGetTheSpecifiedCell() {
        Character testChar = 'O';
        emptyBoard.markCell(1, testChar);
        assertEquals(testChar, emptyBoard.getCell(1));
    }
}
