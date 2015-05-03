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
    ArrayList<ArrayList<Character>> emptyGameBoardArray;
    ArrayList<ArrayList<Character>> fullGameBoardArray;

    @Before
    public void setUp() throws Exception {
        emptyGameBoardArray = new ArrayList<>(3);
        fullGameBoardArray = new ArrayList<>(3);
        for (int index = 0; index < 3; index++) {
            emptyGameBoardArray.add(new ArrayList<>(Collections.nCopies(3, ' ')));
            fullGameBoardArray.add(index, new ArrayList<>(Collections.nCopies(3, 'X')));
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
    }

    @Test
    public void shouldBeAbleToTellWhenBoardIsFull() {
        assertTrue(fullBoard.isFull());
    }

    @Test
    @Ignore
    public void shouldTellWhenPlayerHasWonByRow() throws Exception {
        emptyGameBoardArray.set(0, new ArrayList<>(Collections.nCopies(3, 'X')));

        Board winningBoard = new Board(emptyGameBoardArray);

        assertTrue(winningBoard.playerHasWon('X'));
    }

    @Test
    public void shouldInformUserIfCellIsAvailable() {
        assertTrue(emptyBoard.isCellAvailable(1));
    }

    @Test
    public void shouldInformUserIfCellIsUnavailable() {
        emptyGameBoardArray.get(0).set(0, 'X');

        assertFalse(emptyBoard.isCellAvailable(1));
    }
}